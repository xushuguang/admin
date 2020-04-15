package com.james.admin.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.james.admin.dao.VideosMapper;
import com.james.admin.domain.Videos;
import com.james.admin.enums.BaseCode;
import com.james.admin.response.BaseResponse;
import com.james.admin.utils.FileUtil;
import com.james.admin.utils.FtpUtil;
import com.james.admin.utils.IDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@RestController
public class VideosController {

    @Value("${FTP.VIDEOPATH}")
    private String videoPath;
    // 访问图片时的基础url
    @Value("${FTP.VIDEOBASEURL}")
    private String videoBaseUrl;

    private static Logger logger = LoggerFactory.getLogger( VideosController.class );

    private static Gson gson = new GsonBuilder().create();

    @Autowired
    private VideosMapper videosMapper;


    @RequestMapping(value = "/videos/uploadVideo", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse uploadVideo(HttpServletRequest request){

        BaseResponse resp = null;
        try{

            String remark = request.getParameter("remark");
            String operatorStr = request.getParameter("operator");
            MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
            MultipartFile uploadFile =  req.getFile("file");
            String oldName = uploadFile.getOriginalFilename();
            String videoName = IDUtil.getUUID()+oldName.substring(oldName.lastIndexOf("."));

            InputStream input = uploadFile.getInputStream();

            String filePath = FileUtil.getFilePathByDate();

            Boolean success = FtpUtil.uploadFile(videoPath,filePath,videoName,input);

            if (success){
                Long operator = Long.valueOf(operatorStr);
                Videos videos = new Videos();
                videos.setVdName(videoName);
                videos.setVdUrl(videoBaseUrl + "/" + filePath+ "/" + videoName);
                videos.setRemark(remark);
                videos.setOperator(operator);
                videosMapper.addVideos(videos);

                resp = new BaseResponse(videos.getVdUrl());
            }else {
                resp = new BaseResponse(BaseCode.UPLOAD_VIDEO_FAIL.getCode(),BaseCode.UPLOAD_VIDEO_FAIL.getMsg());
            }

        }catch (Exception e) {
            logger.error("VideosController uploadVideo error!", e);
        }

        return resp;

    }

    @RequestMapping(value = "/videos/getAllVideos", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse getAllVideos(HttpServletRequest request, HttpServletResponse response){
        BaseResponse resp = null;
        try{

            List<Videos> list = videosMapper.selectAllVideos();
            resp = new BaseResponse(gson.toJson(list));

        }catch (Exception e) {
            logger.error("VideosController getAllVideos error!", e);
            resp = new BaseResponse(BaseCode.GET_VIDEO_FAIL.getCode(),BaseCode.GET_VIDEO_FAIL.getMsg());
        }

        return resp;

    }

    @RequestMapping(value = "/videos/getVideosByUsers", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse getVideosByUsers(HttpServletRequest request, HttpServletResponse response){
        BaseResponse resp = null;
        try{

            String userIdStr = request.getParameter("userId");
            Long userId = Long.valueOf(userIdStr);

            List<Videos> list = videosMapper.selectVideosByUser(userId);
            resp = new BaseResponse(gson.toJson(list));

        }catch (Exception e) {
            logger.error("VideosController getVideosByUsers error!", e);
            resp = new BaseResponse(BaseCode.GET_VIDEO_FAIL.getCode(),BaseCode.GET_VIDEO_FAIL.getMsg());
        }

        return resp;

    }

}

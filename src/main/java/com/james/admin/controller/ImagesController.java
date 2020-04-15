package com.james.admin.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.james.admin.dao.ImagesMapper;
import com.james.admin.domain.Images;
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
public class ImagesController {

    @Value("${FTP.IMAGEPATH}")
    private String imagePath;
    // 访问图片时的基础url
    @Value("${FTP.IMAGEBASEURL}")
    private String imageBaseUrl;

    private static Logger logger = LoggerFactory.getLogger( ImagesController.class );

    private static Gson gson = new GsonBuilder().create();

    @Autowired
    private ImagesMapper imagesMapper;


    @RequestMapping(value = "/images/uploadImage", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse uploadImage(HttpServletRequest request){

        BaseResponse resp = null;
        try{

            String remark = request.getParameter("remark");
            String operatorStr = request.getParameter("operator");
            MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
            MultipartFile uploadFile =  req.getFile("file");
            String oldName = uploadFile.getOriginalFilename();
            String imgName = IDUtil.getUUID()+oldName.substring(oldName.lastIndexOf("."));

            InputStream input = uploadFile.getInputStream();

            String filePath = FileUtil.getFilePathByDate();

            Boolean success = FtpUtil.uploadFile(imagePath,filePath,imgName,input);

            if (success){
                Long operator = Long.valueOf(operatorStr);
                Images images = new Images();
                images.setImgName(imgName);
                images.setImgUrl(imageBaseUrl + "/" + filePath+ "/" + imgName);
                images.setRemark(remark);
                images.setOperator(operator);
                imagesMapper.addImages(images);

                resp = new BaseResponse(images.getImgUrl());
            }else {
                resp = new BaseResponse(BaseCode.UPLOAD_IMG_FAIL.getCode(),BaseCode.UPLOAD_IMG_FAIL.getMsg());
            }

        }catch (Exception e) {
            logger.error("ImagesController uploadImage error!", e);
        }

        return resp;

    }

    @RequestMapping(value = "/images/getAllImages", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse getAllImages(HttpServletRequest request, HttpServletResponse response){
        BaseResponse resp = null;
        try{

            List<Images> list = imagesMapper.selectAllImages();
            resp = new BaseResponse(gson.toJson(list));

        }catch (Exception e) {
            logger.error("ImagesController getAllImages error!", e);
            resp = new BaseResponse(BaseCode.GET_IMG_FAIL.getCode(),BaseCode.GET_IMG_FAIL.getMsg());
        }

        return resp;

    }

    @RequestMapping(value = "/images/getImagesByUsers", method = { RequestMethod.POST,RequestMethod.GET})
    public BaseResponse getImagesByUsers(HttpServletRequest request, HttpServletResponse response){
        BaseResponse resp = null;
        try{

            String userIdStr = request.getParameter("userId");
            Long userId = Long.valueOf(userIdStr);

            List<Images> list = imagesMapper.selectImagesByUser(userId);
            resp = new BaseResponse(gson.toJson(list));

        }catch (Exception e) {
            logger.error("ImagesController getImagesByUsers error!", e);
            resp = new BaseResponse(BaseCode.GET_IMG_FAIL.getCode(),BaseCode.GET_IMG_FAIL.getMsg());
        }

        return resp;

    }

}

package com.james.admin.controller;

import com.google.gson.Gson;
import com.james.admin.dao.UsersMapper;
import com.james.admin.domain.Users;
import com.james.admin.enums.BaseCode;
import com.james.admin.response.BaseResponse;
import com.james.admin.utils.ThreeDESUtil;
import com.oversea.common.manager.ResourcesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private UsersMapper usersMapper;

    @Resource
    private ResourcesManager resourcesManager;

    @RequestMapping(value = "/users/login", method = { RequestMethod.POST,RequestMethod.GET})
    @CrossOrigin
    public BaseResponse login(@RequestParam String userName, @RequestParam String password) {
        BaseResponse response = null;
        try{
            resourcesManager.getSaleResourceByType("123123123");
            Users param = new Users();
            param.setUserName(userName);
            param.setPassword(ThreeDESUtil.encryptMode(password));
            Users users = usersMapper.selectUsersByUserNameAndPassword(param);
            if (users!=null){
                response = new BaseResponse(String.valueOf(users.getId()));
            }else {
                response = new BaseResponse(BaseCode.LOGIN_ERROR.getCode(),BaseCode.LOGIN_ERROR.getMsg());
            }
        }catch (Exception e){
          logger.error("UserController login error---",e);
        }
        return response;
    }

}

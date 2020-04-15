package com.james.admin.controller;

import com.james.admin.constants.KafkaTopicContant;
import com.james.admin.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisContoller {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getRedis")
    public String getRedis(){
        String result1 = redisUtil.getString(KafkaTopicContant.TEST1);
        String result2 = redisUtil.getString(KafkaTopicContant.TEST2);
        String result3 = redisUtil.getString(KafkaTopicContant.TEST3);
        String result4 = redisUtil.getString(KafkaTopicContant.TEST4);
        return result1+"=="+result2+"=="+result3+"=="+result4;
    }

}

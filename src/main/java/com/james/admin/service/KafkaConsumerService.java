package com.james.admin.service;

import com.james.admin.constants.KafkaTopicContant;
import com.james.admin.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static Logger logger = LoggerFactory.getLogger( KafkaConsumerService.class );

    @Autowired
    private RedisUtil redisUtil;

    @KafkaListener(topics = KafkaTopicContant.TEST1)
    public void consumer1(String msg){

        redisUtil.setString(KafkaTopicContant.TEST1,msg);
    }

    @KafkaListener(topics = KafkaTopicContant.TEST2)
    public void consumer2(String msg){
        redisUtil.setString(KafkaTopicContant.TEST2,msg);
    }

    @KafkaListener(topics = KafkaTopicContant.TEST3)
    public void consumer3(String msg){
        redisUtil.setString(KafkaTopicContant.TEST3,msg);
    }

    @KafkaListener(topics = KafkaTopicContant.TEST4)
    public void consumer4(String msg){
        redisUtil.setString(KafkaTopicContant.TEST4,msg);
    }
}

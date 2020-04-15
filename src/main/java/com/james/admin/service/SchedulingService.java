package com.james.admin.service;

import com.james.admin.constants.KafkaTopicContant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulingService {
//    @Autowired
//    private KafkaProducerService kafkaProducerService;
//
//    @Scheduled(cron = "0/10 * * * * ? ")
//    public void test(){
//
//        kafkaProducerService.sendMessage(KafkaTopicContant.TEST1,"this is test1 msg"+new Date());
//        kafkaProducerService.sendMessage(KafkaTopicContant.TEST2,"this is test2 msg"+new Date());
//        kafkaProducerService.sendMessage(KafkaTopicContant.TEST3,"this is test3 msg"+new Date());
//        kafkaProducerService.sendMessage(KafkaTopicContant.TEST4,"this is test4 msg"+new Date());
//    }
}

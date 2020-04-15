package com.james.admin.controller;

import com.james.admin.constants.KafkaTopicContant;
import com.james.admin.service.KafkaConsumerService;
import com.james.admin.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    private static Logger logger = LoggerFactory.getLogger( KafkaController.class );

    @GetMapping("/kafka")
    public void kafka() {
       kafkaProducerService.sendMessage(KafkaTopicContant.TEST1,"this is test1 msg");
       kafkaProducerService.sendMessage(KafkaTopicContant.TEST2,"this is test2 msg");
       kafkaProducerService.sendMessage(KafkaTopicContant.TEST3,"this is test3 msg");
       kafkaProducerService.sendMessage(KafkaTopicContant.TEST4,"this is test4 msg");
    }
}

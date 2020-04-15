package com.james.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic,String msg){
        kafkaTemplate.send(topic,msg);
    }
}

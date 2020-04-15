package com.james.admin.controller;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.james.admin.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger( DemoController.class );

    @ApolloJsonValue("${hello:'这是默认的输出'}")
    private String hello;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/")
    public String hi() {

        logger.debug( "debug log..." );
        logger.info( "info log..." );
        logger.warn( "warn log..." );
        logger.error("error log...");


        return hello;
    }

}

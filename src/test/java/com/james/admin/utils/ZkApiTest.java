package com.james.admin.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZkApiTest {
    @Autowired
    private ZkApi zkApi;

    @Test
    public void testInit(){
        zkApi.init();
    }
}

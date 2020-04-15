package com.james.admin.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IDUtilTest {

    @Test
    public void testUUID() {
        for (int i = 0; i < 100; i++) {
            String id = IDUtil.getUUID();
            System.out.println(id);
        }
    }


}

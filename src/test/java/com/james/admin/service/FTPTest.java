package com.james.admin.service;

import com.james.admin.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FTPTest{

    @Test
    public void testUploadFile() throws IOException {
//        读取本地文件，给出的是本地文件地址
//        FileInputStream inputStream = new FileInputStream(new File("/Users/taofen8/Desktop/test.mp4"));
//
//
//        FtpUtil.uploadFile("/home/ftpuser/video","/11","test.mp4",inputStream);
    }

}

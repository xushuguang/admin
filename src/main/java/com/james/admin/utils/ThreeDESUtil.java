package com.james.admin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDESUtil {

    private static Logger logger = LoggerFactory.getLogger( ThreeDESUtil.class );

    public static final byte[] keyByte = "Wo12deOC3PcnfRgh9DloJe5V".getBytes();
    private static final String Algorithm = "DESede";  //定义 加密算法,可用 DES,DESede,Blowfish

    /**
     * 加密字符串
     * @param src
     * @return
     */
    public static String encryptMode(String src) {
        try { // 生成密钥
            byte[] srcByte = src.getBytes();
            SecretKey deskey = new SecretKeySpec(keyByte, Algorithm); // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return new sun.misc.BASE64Encoder().encode(c1.doFinal(srcByte));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     * @param src
     * @return
     */
    public static String decryptMode(String src) {
        try { // 生成密钥
            SecretKey deskey = new SecretKeySpec(keyByte, Algorithm); // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);

            return new String(c1.doFinal(new BASE64Decoder().decodeBuffer(src)));

        } catch (java.security.NoSuchAlgorithmException e1) {
            logger.error("ERROR IN encryptMode cookie1={}",src,e1);
        } catch (javax.crypto.NoSuchPaddingException e2) {
            logger.error("ERROR IN encryptMode cookie2={}",src,e2);
        } catch (java.lang.Exception e3) {
            logger.error("ERROR IN encryptMode cookie3={}",src,e3);
        }
        return null;
    }


    public static void main(String[] args){
        String str = ThreeDESUtil.encryptMode("Pa55w0rd!");
        System.out.println(str);
        String str1 = ThreeDESUtil.decryptMode("A+XkBxDzHWXij2TAsSccCw==");
        System.out.println(str1);
    }






}

package com.example.algorithm.encryption.symmetric;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2021/4/13
 */
public class Base64En {


    /**
     * base64加密
     * @param content
     * @return
     */
    public static String encode(String content) {
        return new BASE64Encoder().encodeBuffer(content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * base64解密
     */
    public static String decode(String data) {
        byte[] b;
        try {
            b = new BASE64Decoder().decodeBuffer(data);
            return new String(b);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}

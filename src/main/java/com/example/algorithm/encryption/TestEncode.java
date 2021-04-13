package com.example.algorithm.encryption;

import com.example.algorithm.encryption.symmetric.AES;
import com.example.algorithm.encryption.symmetric.Base64En;

import java.util.Arrays;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2021/4/13
 */
public class TestEncode {


    public static void main(String[] args) {

        //Base64 加密
        String baseEn = Base64En.encode("12345");
        System.out.println(baseEn);

        //BASE64 解密
        System.out.println(Base64En.decode(baseEn));

        String key = AES.getKey("123",128);
        System.out.println(key);
        //AES加密
        String encodeData = AES.AESEncode(key, "shuju1234");
        System.out.println(encodeData);
        //AES解密
        System.out.println(AES.decode(key, encodeData));
    }
}

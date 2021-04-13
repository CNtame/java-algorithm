package com.example.algorithm.encryption.symmetric;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author liu
 * @version 1.0
 * @description 对称加密 AES
 * @createDate 2021/4/13
 */
public class AES {


    /**
     * 生成Key
     */
    public static String getKey(String originKey,int digitNum) {
        try {
            // 构造密钥生成器 不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            keyGenerator.init(digitNum,new SecureRandom(originKey.getBytes()));
            // 3.产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
            return Hex.encodeHexString(keyBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 用jdk内部函数实现
     * 128、192、256
     * @param content
     * @return
     */
    public static String AESEncode(String encodeKey,String content) {

        try {

            Key key = new SecretKeySpec(Hex.decodeHex(encodeKey),"AES");

            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");

            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes(StandardCharsets.UTF_8);
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] result = cipher.doFinal(byte_encode);

            return new BASE64Encoder().encodeBuffer(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String decode(String encodeKey,String content) {

        try {


            // 5.根据字节数组生成AES密钥
            Key key = new SecretKeySpec(Hex.decodeHex(encodeKey), "AES");
            // 6.根据指定算法AES自成密码器
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] c = new BASE64Decoder().decodeBuffer(content);
            byte[] result = cipher.doFinal(c);
            return new String(result, StandardCharsets.UTF_8);
        }catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException | DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }



}

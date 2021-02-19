package com.gina.util;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * @date 2019/10/15 13:46
 */
public class AESUtil {

    private static final String ENCRYPTION_KEY = "7freshapp";
    private static final String ENCRYPTION_IV = "7freshappivparam";//必须是16位

    /**
     * 加密
     * @param src
     * @return
     */
    public static String encrypt(String src) {
       try{
           Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
           cipher.init(Cipher.ENCRYPT_MODE, makeKey(), makeIv());
           return Base64.getUrlEncoder().withoutPadding().encodeToString(cipher.doFinal(src.getBytes()));
       }catch (Exception e){
           throw new RuntimeException("encrypt src error",e);
       }
    }

    /**
     * 解密
     * @param src
     * @return
     */
    public static String decrypt(String src) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, makeKey(), makeIv());
            return new String(cipher.doFinal(Base64.getUrlDecoder().decode(src.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            throw new RuntimeException("decrypt src error",e);
        }
    }

    private static AlgorithmParameterSpec makeIv() {
        return new IvParameterSpec(ENCRYPTION_IV.getBytes(StandardCharsets.UTF_8));
    }

    private static Key makeKey() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] key = md.digest(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(key, "AES");
    }

}

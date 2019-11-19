package com.work.daily.dailyfrash.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class PasswordUtils {
	 //algorithm
	private static final String KEY_ALGORITHM = "DES";
    
    private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
    
    public static final String KEY = "project_dailyfrash";
    
    private static SecretKey keyGenerator(String keyStr) throws Exception {
        byte input[] = HexString2Bytes(keyStr);
        DESKeySpec desKey = new DESKeySpec(input);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

    private static int parse(char c) {
        if (c >= 'a') return (c - 'a' + 10) & 0x0f;
        if (c >= 'A') return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    public static byte[] HexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    public static String encode(String data) throws Exception {
        Key deskey = keyGenerator(KEY);

        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();

        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        byte[] results = cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(results);
    }

    public static String encode(String data, String key) throws Exception {
        Key deskey = keyGenerator(key);
        
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();
        
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        byte[] results = cipher.doFinal(data.getBytes());

        
        return Base64.encodeBase64String(results);
    }

    public static String encodeURLSaft(String data, String key) throws Exception {
        Key deskey = keyGenerator(key);
        
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();
        
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        byte[] results = cipher.doFinal(data.getBytes());

        
        return Base64.encodeBase64URLSafeString(results);
    }

    public static String decode(String data, String key) throws Exception {
        Key deskey = keyGenerator(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

    public static String decode(String data) throws Exception {
        Key deskey = keyGenerator(KEY);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, deskey);

        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }
	
}

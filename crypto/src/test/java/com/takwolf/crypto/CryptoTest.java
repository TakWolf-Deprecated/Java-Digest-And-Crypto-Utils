package com.takwolf.crypto;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;

public class CryptoTest {
    
    private static final byte[] KEY_RAW = "58e00488-2014-4947-ab29-40cfa1f0d692".getBytes(StandardCharsets.UTF_8);
    private static final String[] DATAS = new String[]{
            "HelloWorld",
            "TakWolf",
            "Google",
            "今天的风儿有点喧嚣",
            "おはよう",
            "http://takwolf.com"
    };

    @Test
    public void testAES() throws CryptoException {
        SecretKey key = Crypto.AES.generateSecret(KEY_RAW);
        IvParameterSpec iv = Crypto.AES.generateIv(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(Crypto.AES.decrypt(key, iv, Crypto.AES.encrypt(key, iv, data.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        }
    }

    @Test
    public void testDESede() throws CryptoException {
        SecretKey key = Crypto.DESede.generateSecret(KEY_RAW);
        IvParameterSpec iv = Crypto.DESede.generateIv(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(Crypto.DESede.decrypt(key, iv, Crypto.DESede.encrypt(key, iv, data.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        }
    }

}

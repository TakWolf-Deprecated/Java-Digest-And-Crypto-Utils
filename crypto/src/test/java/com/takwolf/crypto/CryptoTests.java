package com.takwolf.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class CryptoTests {

    private static final byte[] KEY_RAW = "58e00488-2014-4947-ab29-40cfa1f0d692".getBytes(StandardCharsets.UTF_8);
    private static final String[] DATAS = new String[] {
            "HelloWorld",
            "TakWolf",
            "Google",
            "今天的风儿有点喧嚣",
            "おはよう",
            "http://takwolf.com"
    };

    @Test
    public void testAES() throws CryptoException {
        Crypto aes = new Crypto(Crypto.Algorithm.AES);
        Key key = aes.generateKey(KEY_RAW);
        AlgorithmParameterSpec iv = aes.generateIv(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(aes.decrypt(key, iv, aes.encrypt(key, iv, data.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        }
    }

    @Test
    public void testDESede() throws CryptoException {
        Crypto desede = new Crypto(Crypto.Algorithm.DESEDE);
        Key key = desede.generateKey(KEY_RAW);
        AlgorithmParameterSpec iv = desede.generateIv(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(desede.decrypt(key, iv, desede.encrypt(key, iv, data.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        }
    }

}

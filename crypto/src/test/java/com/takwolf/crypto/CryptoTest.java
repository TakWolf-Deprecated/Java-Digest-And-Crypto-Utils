package com.takwolf.crypto;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;

public class CryptoTest {

    private static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
    private static final byte[] KEY_RAW = "58e00488-2014-4947-ab29-40cfa1f0d692".getBytes(CHARSET_UTF_8);
    private static final String[] DATAS = new String[]{
            "HelloWorld",
            "TakWolf",
            "Google",
            "今天的风儿有点喧嚣",
            "おはよう",
            "http://takwolf.com"
    };

    @Test
    public void testAES() throws Crypto.CryptoException {
        SecretKey key = Crypto.AES.generateSecret(KEY_RAW);
        IvParameterSpec iv = Crypto.AES.generateIV(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(Crypto.AES.decrypt(key, iv, Crypto.AES.encrypt(key, iv, data.getBytes(CHARSET_UTF_8))), CHARSET_UTF_8));
        }
    }

    @Test
    public void testDESede() throws Crypto.CryptoException {
        SecretKey key = Crypto.DESede.generateSecret(KEY_RAW);
        IvParameterSpec iv = Crypto.DESede.generateIV(KEY_RAW);
        for (String data : DATAS) {
            Assert.assertEquals(data, new String(Crypto.DESede.decrypt(key, iv, Crypto.DESede.encrypt(key, iv, data.getBytes(CHARSET_UTF_8))), CHARSET_UTF_8));
        }
    }

}

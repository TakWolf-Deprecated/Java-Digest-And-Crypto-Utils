package com.takwolf.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSATests {

    private static final String TEXT = "Hello World!";

    @Test
    public void testCrypto() throws NoSuchAlgorithmException, CryptoException {
        KeyPair keyPair = RSA.generateKeyPair(2048);
        byte[] crypto = RSA.encrypt(keyPair.getPublic(), TEXT.getBytes(StandardCharsets.UTF_8));
        String text = new String(RSA.decrypt(keyPair.getPrivate(), crypto), StandardCharsets.UTF_8);
        Assert.assertEquals(text, TEXT);
    }

    @Test
    public void testCryptoGenerateKey() throws NoSuchAlgorithmException, CryptoException {
        KeyPair keyPair = RSA.generateKeyPair(2048);
        PrivateKey privateKey = RSA.generatePrivateKey(keyPair.getPrivate().getEncoded());
        PublicKey publicKey = RSA.generatePublicKey(keyPair.getPublic().getEncoded());
        byte[] crypto = RSA.encrypt(publicKey, TEXT.getBytes(StandardCharsets.UTF_8));
        String text = new String(RSA.decrypt(privateKey, crypto), StandardCharsets.UTF_8);
        Assert.assertEquals(text, TEXT);
    }

    @Test
    public void testSignVerify() throws CryptoException {
        KeyPair keyPair = RSA.generateKeyPair(2048);
        for (RSA.SignatureAlgorithm signatureAlgorithm : RSA.SignatureAlgorithm.values()) {
            byte[] sign = RSA.sign(signatureAlgorithm, keyPair.getPrivate(), TEXT.getBytes(StandardCharsets.UTF_8));
            boolean result = RSA.verify(signatureAlgorithm, keyPair.getPublic(), TEXT.getBytes(StandardCharsets.UTF_8), sign);
            Assert.assertTrue(result);
        }
    }

}

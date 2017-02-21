package com.takwolf.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSATest {

    private static final String TEXT = "Hello World!";

    @Test
    public void testRSA() throws NoSuchAlgorithmException, CryptoException {
        KeyPair keyPair = RSA.generateKeyPair(2048);
        byte[] crypto = RSA.encryptByPublicKey(keyPair.getPublic(), TEXT.getBytes(StandardCharsets.UTF_8));
        Assert.assertEquals(new String(RSA.decryptByPrivateKey(keyPair.getPrivate(), crypto), StandardCharsets.UTF_8), TEXT);
    }

    @Test
    public void testKey() throws NoSuchAlgorithmException, CryptoException {
        KeyPair keyPair = RSA.generateKeyPair(2048);
        PrivateKey privateKey = RSA.generatePrivateKey(keyPair.getPrivate().getEncoded());
        PublicKey publicKey = RSA.generatePublicKey(keyPair.getPublic().getEncoded());
        byte[] crypto = RSA.encryptByPublicKey(publicKey, TEXT.getBytes(StandardCharsets.UTF_8));
        Assert.assertEquals(new String(RSA.decryptByPrivateKey(privateKey, crypto), StandardCharsets.UTF_8), TEXT);
    }

}

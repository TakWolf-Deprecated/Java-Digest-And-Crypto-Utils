package com.takwolf.util.digest;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestCoder {

    private final MessageDigest md;

    /**
     * 可选值为：MD2,MD5,SHA-1,SHA-256,SHA-384,SHA-512
     */
    public DigestCoder(String algorithm) {
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getDigest(byte[] input) {
        byte[] buffer = md.digest(input);
        StringBuilder sb = new StringBuilder(buffer.length * 2);
        for (byte b : buffer) {
            sb.append(Character.forDigit((b >>> 4) & 15, 16));
            sb.append(Character.forDigit(b & 15, 16));
        }
        return sb.toString();
    }

    public String getDigest(String plainText) {
        return getDigest(plainText.getBytes(Charset.forName("UTF-8")));
    }

}

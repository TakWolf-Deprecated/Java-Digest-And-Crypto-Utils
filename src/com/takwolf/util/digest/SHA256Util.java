package com.takwolf.util.digest;

public class SHA256Util {

    private static DigestCoder coder = new DigestCoder("SHA-256");

    public final static String getDigest(byte[] input) {
        return coder.getDigest(input);
    }

    public final static String getDigest(String plainText) {
        return coder.getDigest(plainText);
    }

}

package com.takwolf.util.digest;

public class MD5Util {

    private static DigestCoder coder = new DigestCoder("MD5");

    public final static String getDigest(byte[] input) {
        return coder.getDigest(input);
    }

    public final static String getDigest(String plainText) {
        return coder.getDigest(plainText);
    }

}

package com.takwolf.util.digest;

public class MD2Util {

    private static DigestCoder coder = new DigestCoder("MD2");

    public final static String getDigest(byte[] input) {
        return coder.getDigest(input);
    }

    public final static String getDigest(String plainText) {
        return coder.getDigest(plainText);
    }

}

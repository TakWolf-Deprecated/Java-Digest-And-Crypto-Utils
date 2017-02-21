package com.takwolf.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Digest {

    public static final Digest MD2 = new Digest(Algorithm.MD2);
    public static final Digest MD5 = new Digest(Algorithm.MD5);
    public static final Digest SHA1 = new Digest(Algorithm.SHA1);
    public static final Digest SHA256 = new Digest(Algorithm.SHA256);
    public static final Digest SHA384 = new Digest(Algorithm.SHA384);
    public static final Digest SHA512 = new Digest(Algorithm.SHA512);

    public enum Algorithm {

        MD2("MD2"),

        MD5("MD5"),

        SHA1("SHA-1"),

        SHA256("SHA-256"),

        SHA384("SHA-384"),

        SHA512("SHA-512");

        private final String value;

        Algorithm(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private final Algorithm algorithm;

    private Digest(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public byte[] getRaw(byte[] data) {
        try {
            return MessageDigest.getInstance(algorithm.getValue()).digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] getRaw(String data) {
        return getRaw(data.getBytes());
    }

    public String getHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : getRaw(data)) {
            sb.append(String.format("%02x", 0xFF & b));
        }
        return sb.toString();
    }

    public String getHex(String data) {
        return getHex(data.getBytes());
    }

}

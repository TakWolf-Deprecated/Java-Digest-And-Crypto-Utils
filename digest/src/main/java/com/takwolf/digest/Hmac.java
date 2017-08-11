package com.takwolf.digest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public final class Hmac {

    public enum Algorithm {

        MD5("HmacMD5"),

        SHA1("HmacSHA1"),

        SHA224("HmacSHA224"),

        SHA256("HmacSHA256"),

        SHA384("HmacSHA384"),

        SHA512("HmacSHA512");

        private final String value;

        Algorithm(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private final Algorithm algorithm;

    public Hmac(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public SecretKey generateSecret(byte[] seed) {
        return new SecretKeySpec(seed, algorithm.getValue());
    }

    public SecretKey generateSecret() {
        try {
            return KeyGenerator.getInstance(algorithm.getValue()).generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getRaw(SecretKey secret, byte[] data) {
        try {
            Mac mac = Mac.getInstance(algorithm.getValue());
            mac.init(secret);
            return mac.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getRaw(SecretKey secret, String data) {
        return getRaw(secret, data.getBytes());
    }

    public String getHex(SecretKey secret, byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : getRaw(secret, data)) {
            sb.append(String.format("%02x", b & 0xFF));
        }
        return sb.toString();
    }

    public String getHex(SecretKey secret, String data) {
        return getHex(secret, data.getBytes());
    }

}

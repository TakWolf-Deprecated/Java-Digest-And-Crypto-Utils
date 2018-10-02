package com.takwolf.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public final class Crypto {

    public enum Algorithm {

        AES("AES", 16, 16),

        DES("DES", 8, 8),

        DESEDE("DESede", 24, 8);

        private final String value;
        private final int keyLength;
        private final int ivLength;

        Algorithm(String value, int keyLength, int ivLength) {
            this.value = value;
            this.keyLength = keyLength;
            this.ivLength = ivLength;
        }

        public String value() {
            return value;
        }

        public int keyLength() {
            return keyLength;
        }

        public int ivLength() {
            return ivLength;
        }

    }

    private final Algorithm algorithm;

    public Crypto(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Key generateKey(byte[] seed) {
        return new SecretKeySpec(Arrays.copyOf(seed, algorithm.keyLength()), algorithm.value());
    }

    public AlgorithmParameterSpec generateIv(byte[] seed) {
        return new IvParameterSpec(Arrays.copyOf(seed, algorithm.ivLength()));
    }

    public byte[] encrypt(Key key, AlgorithmParameterSpec iv, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] encrypt(Key key, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] decrypt(Key key, AlgorithmParameterSpec iv, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] decrypt(Key key, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

}

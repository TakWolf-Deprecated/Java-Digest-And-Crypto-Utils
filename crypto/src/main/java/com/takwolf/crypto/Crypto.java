package com.takwolf.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class Crypto {

    public static final Crypto AES = new Crypto("AES", 16, 16);
    public static final Crypto DESede = new Crypto("DESede", 24, 8);

    private final String algorithm;
    private final int secretLength;
    private final int ivLength;

    private Crypto(String algorithm, int secretLength, int ivLength) {
        this.algorithm = algorithm;
        this.secretLength = secretLength;
        this.ivLength = ivLength;
    }

    public SecretKey generateSecret(byte[] seed) {
        return new SecretKeySpec(Arrays.copyOf(seed, secretLength), algorithm);
    }

    public IvParameterSpec generateIv(byte[] seed) {
        return new IvParameterSpec(Arrays.copyOf(seed, ivLength));
    }

    public byte[] encrypt(SecretKey secret, IvParameterSpec iv, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, iv);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] encrypt(SecretKey secret, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] decrypt(SecretKey secret, IvParameterSpec iv, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, iv);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    public byte[] decrypt(SecretKey secret, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

}

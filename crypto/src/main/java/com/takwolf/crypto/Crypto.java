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
import java.util.Arrays;

public final class Crypto {

    public static final Crypto AES = new Crypto("AES", 16, 16);
    public static final Crypto DESede = new Crypto("DESede", 24, 8);

    private final String algorithm;
    private final int keyLength;
    private final int ivLength;

    private Crypto(String algorithm, int keyLength, int ivLength) {
        this.algorithm = algorithm;
        this.keyLength = keyLength;
        this.ivLength = ivLength;
    }

    public Key generateKey(byte[] seed) {
        return new SecretKeySpec(Arrays.copyOf(seed, keyLength), algorithm);
    }

    public IvParameterSpec generateIv(byte[] seed) {
        return new IvParameterSpec(Arrays.copyOf(seed, ivLength));
    }

    public byte[] encrypt(Key key, IvParameterSpec iv, byte[] data) throws CryptoException {
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

    public byte[] decrypt(Key key, IvParameterSpec iv, byte[] data) throws CryptoException {
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

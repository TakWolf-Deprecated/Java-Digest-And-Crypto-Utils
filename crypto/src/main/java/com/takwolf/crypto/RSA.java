package com.takwolf.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class RSA {

    private static final String ALGORITHM = "RSA";

    public static KeyPair generateKeyPair(int keysize) throws CryptoException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keysize);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    public static PrivateKey generatePrivateKey(byte[] raw) throws CryptoException {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(raw);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    public static PublicKey generatePublicKey(byte[] raw) throws CryptoException {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(raw);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    public static byte[] encryptByPrivateKey(PrivateKey privateKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    public static byte[] decryptByPrivateKey(PrivateKey privateKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    public static byte[] encryptByPublicKey(PublicKey publicKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    public static byte[] decryptByPublicKey(PublicKey publicKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new CryptoException(e);
        }
    }

}

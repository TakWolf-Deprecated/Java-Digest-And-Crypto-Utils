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

    public enum SignatureAlgorithm {

        MD2("MD2withRSA"),

        MD5("MD5withRSA"),

        SHA1("SHA1withRSA"),

        SHA256("SHA256withRSA"),

        SHA384("SHA384withRSA"),

        SHA512("SHA512withRSA");

        private final String value;

        SignatureAlgorithm(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private static final String ALGORITHM = "RSA";

    /**
     * 生成秘钥对
     * 可以加密的数据长度为：keysize/8-11
     */
    public static KeyPair generateKeyPair(int keysize) throws CryptoException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            keyPairGenerator.initialize(keysize);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 包装私钥，符合 PKCS#8 规范
     */
    public static PrivateKey generatePrivateKey(byte[] raw) throws CryptoException {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(raw);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 包装公钥，符合 X.509 规范
     */
    public static PublicKey generatePublicKey(byte[] raw) throws CryptoException {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(raw);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 公钥加密
     */
    public static byte[] encrypt(PublicKey publicKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 私钥解密
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] data) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 私钥签名
     */
    public static byte[] sign(SignatureAlgorithm signatureAlgorithm, PrivateKey privateKey, byte[] data) throws CryptoException {
        try {
            Signature signature = Signature.getInstance(signatureAlgorithm.getValue());
            signature.initSign(privateKey);
            signature.update(data);
            return signature.sign();
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new CryptoException(e);
        }
    }

    /**
     * 公钥校验
     */
    public static boolean verify(SignatureAlgorithm signatureAlgorithm, PublicKey publicKey, byte[] data, byte[] sign) throws CryptoException {
        try {
            Signature signature = Signature.getInstance(signatureAlgorithm.getValue());
            signature.initVerify(publicKey);
            signature.update(data);
            return signature.verify(sign);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new CryptoException(e);
        }
    }

}

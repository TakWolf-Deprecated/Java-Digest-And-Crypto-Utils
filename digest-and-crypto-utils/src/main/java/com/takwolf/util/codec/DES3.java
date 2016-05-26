/*
 * Copyright 2015-2016 TakWolf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.takwolf.util.codec;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public final class DES3 {

    private DES3() {}

    private static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");

    public static String encrypt(String key, String iv, String data) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key desKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(CHARSET_UTF_8));
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, desKey, ivParameterSpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(CHARSET_UTF_8)));
    }

    public static String encrypt(String key, String data) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key desKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(CHARSET_UTF_8)));
    }

    public static String decrypt(String key, String iv, String data) throws BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key desKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(CHARSET_UTF_8));
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, desKey, ivParameterSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)), CHARSET_UTF_8);
    }

    public static String decrypt(String key, String data) throws BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key desKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)), CHARSET_UTF_8);
    }

}

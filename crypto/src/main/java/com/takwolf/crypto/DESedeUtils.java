package com.takwolf.crypto;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public final class DESedeUtils {

    private DESedeUtils() {
    }

    private static final SecretKeyFactory secretKeyFactory;

    static {
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public SecretKey generateSecret(byte[] seed) throws InvalidKeyException, InvalidKeySpecException {
        return secretKeyFactory.generateSecret(new DESedeKeySpec(seed));
    }

    public IvParameterSpec generateIV(byte[] seed) {
        return new IvParameterSpec(Arrays.copyOf(seed, 8));
    }

}

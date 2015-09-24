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

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Digest {

    public static final Digest MD2 = new Digest("MD2");
    public static final Digest MD5 = new Digest("MD5");
    public static final Digest SHA1 = new Digest("SHA-1");
    public static final Digest SHA256 = new Digest("SHA-256");
    public static final Digest SHA384 = new Digest("SHA-384");
    public static final Digest SHA512 = new Digest("SHA-512");

    private final MessageDigest md;

    private Digest(String algorithm) {
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public byte[] getRaw(byte[] input) {
        return md.digest(input);
    }

    public byte[] getRaw(String input) {
        return getRaw(input.getBytes(Charset.forName("UTF-8")));
    }

    public String getMessage(byte[] input) {
        byte[] buffer = getRaw(input);
        StringBuilder sb = new StringBuilder(buffer.length * 2);
        for (byte b : buffer) {
            sb.append(Character.forDigit((b >>> 4) & 15, 16));
            sb.append(Character.forDigit(b & 15, 16));
        }
        return sb.toString();
    }

    public String getMessage(String input) {
        return getMessage(input.getBytes(Charset.forName("UTF-8")));
    }

}

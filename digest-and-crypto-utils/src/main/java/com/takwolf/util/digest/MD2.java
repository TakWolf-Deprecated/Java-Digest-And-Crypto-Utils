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

package com.takwolf.util.digest;

public class MD2 {

    private static final DigestCoder coder = new DigestCoder("MD2");

    public static byte[] getRawDigest(byte[] input) {
        return coder.getRawDigest(input);
    }

    public static byte[] getRawDigest(String input) {
        return coder.getRawDigest(input);
    }

    public static String getMessageDigest(byte[] input) {
        return coder.getMessageDigest(input);
    }

    public static String getMessageDigest(String input) {
        return coder.getMessageDigest(input);
    }

}

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

package com.takwolf.app.demo;

import com.takwolf.util.coder.Base64;
import com.takwolf.util.crypto.AES;
import com.takwolf.util.crypto.DES3;
import com.takwolf.util.digest.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("----- Digest -----");
        String plainText = "HelloWorld";
        System.out.println("MD2:" + MD2.getMessageDigest(plainText));
        System.out.println("MD5:" + MD5.getMessageDigest(plainText));
        System.out.println("SHA1:" + SHA1.getMessageDigest(plainText));
        System.out.println("SHA256:" + SHA256.getMessageDigest(plainText));
        System.out.println("SHA384:" + SHA384.getMessageDigest(plainText));
        System.out.println("SHA512:" + SHA512.getMessageDigest(plainText));

        System.out.println("----- Crypto -----");
        String text = "HelloWorld";
        String key = "19B38D18-6CA2-8619-2424-D307381AFA11";
        String strAes = AES.encrypt(key, text);
        String strDes = DES3.encrypt(key, text);
        System.out.println(strAes + " -> " + AES.decrypt(key, strAes));
        System.out.println(strDes + " -> " + DES3.decrypt(key, strDes));

        System.out.println("----- Base64 -----");
        System.out.println(Base64.encode("HelloWorld"));
        System.out.println(Base64.decode("SGVsbG9Xb3JsZA=="));
    }

}

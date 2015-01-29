package com.takwolf.app.demo;

import com.takwolf.util.coder.Base64;
import com.takwolf.util.crypto.AESUtil;
import com.takwolf.util.crypto.DES3Util;
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
        String strAes = AESUtil.encrypt(key, text);
        String strDes = DES3Util.encrypt(key, text);
        System.out.println(strAes + " -> " + AESUtil.decrypt(key, strAes));
        System.out.println(strDes + " -> " + DES3Util.decrypt(key, strDes));

        System.out.println("----- Base64 -----");
        System.out.println(Base64.encode("HelloWorld"));
        System.out.println(Base64.decode("SGVsbG9Xb3JsZA=="));
    }

}

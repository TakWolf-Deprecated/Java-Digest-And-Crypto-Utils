package com.takwolf.main;

import com.takwolf.util.digest.MD2Util;
import com.takwolf.util.digest.MD5Util;
import com.takwolf.util.digest.SHA1Util;
import com.takwolf.util.digest.SHA256Util;
import com.takwolf.util.digest.SHA384Util;
import com.takwolf.util.digest.SHA512Util;

public class JavaMain {

    public static void main(String[] args) {
        System.out.println("----- Digest -----");
        String plainText = "HelloWorld";
        System.out.println("MD2:" + MD2Util.getDigest(plainText));
        System.out.println("MD5:" + MD5Util.getDigest(plainText));
        System.out.println("SHA1:" + SHA1Util.getDigest(plainText));
        System.out.println("SHA256:" + SHA256Util.getDigest(plainText));
        System.out.println("SHA384:" + SHA384Util.getDigest(plainText));
        System.out.println("SHA512:" + SHA512Util.getDigest(plainText));
        

    }

}

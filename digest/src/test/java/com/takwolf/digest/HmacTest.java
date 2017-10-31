package com.takwolf.digest;

import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

public class HmacTest {

    private static final String KEY = "58e00488-2014-4947-ab29-40cfa1f0d692";

    @Test
    public void testMD5() {
        Hmac hmacMd5 = new Hmac(Hmac.Algorithm.MD5);
        Key key = hmacMd5.generateKey(KEY);
        Assert.assertEquals("864028f18855432ce226e5c4058a37e0", hmacMd5.getHex(key, "HelloWorld"));
        Assert.assertEquals("6a2a30d3c178b96b67e4db44bae69930", hmacMd5.getHex(key, "TakWolf"));
        Assert.assertEquals("8a6721a81c04528ab45a053129e73e57", hmacMd5.getHex(key, "Google"));
        Assert.assertEquals("be589c7a552349e2887f34c23e1d4fe6", hmacMd5.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("6bb0646517b859bbc363612b7df4bc78", hmacMd5.getHex(key, "おはよう"));
        Assert.assertEquals("dee7933d8d171c600f177ca8ef5d17da", hmacMd5.getHex(key, "http://takwolf.com"));
    }

    @Test
    public void testSHA1() {
        Hmac hmacSha1 = new Hmac(Hmac.Algorithm.SHA1);
        Key key = hmacSha1.generateKey(KEY);
        Assert.assertEquals("cb5001a75a7257f5b135ac27cb4e4f1929d7e86f", hmacSha1.getHex(key, "HelloWorld"));
        Assert.assertEquals("1e796fcb63eb2c9a601e48c61c09e01ba3517f2a", hmacSha1.getHex(key, "TakWolf"));
        Assert.assertEquals("638a0b626e17c003a008d372a844da4babf0dbd5", hmacSha1.getHex(key, "Google"));
        Assert.assertEquals("3f5a7045a78a38293b165f6e6c39d565c9b8de82", hmacSha1.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("9a679be8b8877086be0554d97da5fc0394c93a41", hmacSha1.getHex(key, "おはよう"));
        Assert.assertEquals("a95c24ba15b2250a9ec8ada7471057b9e7a5a3d0", hmacSha1.getHex(key, "http://takwolf.com"));
    }

    // TODO 结果与在线工具不匹配
    @Test(expected = Throwable.class)
    public void testSHA224() {
        Hmac hmacSha224 = new Hmac(Hmac.Algorithm.SHA224);
        Key key = hmacSha224.generateKey(KEY);
        Assert.assertEquals("34552c5201b9daeeba88fd83fab9a3527e034c04cfdc7fedf3f6c2dd", hmacSha224.getHex(key, "HelloWorld"));
        Assert.assertEquals("54d7a273e65d8df1c6712b3d3493f8d716f28e56b6c6a920316a12d5", hmacSha224.getHex(key, "TakWolf"));
        Assert.assertEquals("68ed0c9a015287ecd9b21943b39c760a6020147b1dcf682f2ae6579b", hmacSha224.getHex(key, "Google"));
        Assert.assertEquals("201e20d852228eaa80b377a84030bd59911c2ec11ce60b16644356c9", hmacSha224.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("7e667a312b3927b8c896fefc6809076da6974f40662ac49309755c08", hmacSha224.getHex(key, "おはよう"));
        Assert.assertEquals("dc5f305b0a48e312a10021945280874d45fd6fe594f9ffed495645e9", hmacSha224.getHex(key, "http://takwolf.com"));
    }

    @Test
    public void testSHA256() {
        Hmac hmacSha256 = new Hmac(Hmac.Algorithm.SHA256);
        Key key = hmacSha256.generateKey(KEY);
        Assert.assertEquals("a6d3969a67e0d9b79d1ba2b49260e8b7ddde829a963fc2c054bd1a7a873f89bf", hmacSha256.getHex(key, "HelloWorld"));
        Assert.assertEquals("16d60814fc4a0750231b18592675223aba58e4fbdf121472e17af5734dea925b", hmacSha256.getHex(key, "TakWolf"));
        Assert.assertEquals("28dc80f322a836ec1043856635abfb5e5ec4a9501b60047e539870ad0628fe81", hmacSha256.getHex(key, "Google"));
        Assert.assertEquals("0c0f8a6879c400173beebb1f9ddfdb8cf690993066cb16d27dbd2e1084fdca91", hmacSha256.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("ad412d41790a692206a7997fa47464ab13ae7f5d7e8c05786ee4414f0b28695e", hmacSha256.getHex(key, "おはよう"));
        Assert.assertEquals("be12d49962858cb4874bb16cb59823672d2ff1127f2cc0f18d3e336a2d3019aa", hmacSha256.getHex(key, "http://takwolf.com"));
    }

    // TODO 结果与在线工具不匹配
    @Test
    public void testSHA384() {
        Hmac hmacSha384 = new Hmac(Hmac.Algorithm.SHA384);
        Key key = hmacSha384.generateKey(KEY);
        Assert.assertEquals("d7219a35c8363ec85d11701ffc950f5e55b46ca856fb2883243ad9b98eb6ce5e5c3c61ce0ed31d1fcfdbb9c91ff1fdec", hmacSha384.getHex(key, "HelloWorld"));
        Assert.assertEquals("83415e6f1e3a92d071b599f1eba2f584cd651ceb16b4044b887c00ba5c0b2eefcc3b1e7379b69c6fcd8c555697dd8774", hmacSha384.getHex(key, "TakWolf"));
        Assert.assertEquals("6b4f26e36f11fcebc9004248f0f6e16f5933d6f625fab065d13fdb5489f1c4ef72508ec26cd5eb088ebd7b89217f797d", hmacSha384.getHex(key, "Google"));
        Assert.assertEquals("5d21900e990242f82b24834de88ef209c6e8b6435714ffcec1c92c0cccdc1c98e8b0a180b3ad29e219a17fa1e830f4f1", hmacSha384.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("49f23096f091740d1cb5da1ff59b2872c965957e2857f071d1da0709004aac04ed4d5be1955858e29bcd431dc1bd9eb1", hmacSha384.getHex(key, "おはよう"));
        Assert.assertEquals("745b4b82f2e0adaed40fe99b984aba551724b218b2dfb676753b3e910dc451c5c5b72850a0609a0317ac8b0e009e6102", hmacSha384.getHex(key, "http://takwolf.com"));
    }

    @Test
    public void testSHA512() {
        Hmac hmacSha512 = new Hmac(Hmac.Algorithm.SHA512);
        Key key = hmacSha512.generateKey(KEY);
        Assert.assertEquals("251d1e3034a48d21ccee4f0641dba9d56d94a0aee03af870348fc9a64b2e8250e641e0c88f23e9619a047549cba1b3261e562de2f30e7c9d3692ce186e05e459", hmacSha512.getHex(key, "HelloWorld"));
        Assert.assertEquals("21f29be171a34d0b8b5bf17f50aeaaf538ea7452f9704ba8ffe7a22567f59d73a8a6427b5d93c0c5b4d62667f7e10f19bc3e97828f0e327e309057b6ede80166", hmacSha512.getHex(key, "TakWolf"));
        Assert.assertEquals("35e6a546aa7f8ab9dc241d82bc82484fbb4be8be01bb4387f6ed398584ee342dd7a443e7fe63ee874f98081874dede7208c6d5808e1307b31a21656770ab6c2e", hmacSha512.getHex(key, "Google"));
        Assert.assertEquals("779ced1583cf84c79c113de7c42c53e7122120b85876c7ae30ed20cec8e1bc6d213d2c99b609f4fc1f4679f7d5fa8f37b8b29de095212ac0077ca9b9f48fe67a", hmacSha512.getHex(key, "今天的风儿有点喧嚣"));
        Assert.assertEquals("7c77db03bad210289dad3a0cff9ad408293b74b9e5f58b2221942cc9bede68eb85758d3c6bfd65a76cdb6697c111ba2aa0e0c96c125be1a987825c67545be34d", hmacSha512.getHex(key, "おはよう"));
        Assert.assertEquals("24edf359aa00579472689660463e14af65981be4cb4961e1de337bbc4f22270f8902737700845c35ef0e624506e816335e95d1453dee8a9e3937a80264cee017", hmacSha512.getHex(key, "http://takwolf.com"));
    }

}

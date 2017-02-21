package com.takwolf.digest;

import org.junit.Assert;
import org.junit.Test;

public final class DigestTest {

    @Test
    public void testMD5() {
        Digest md5 = new Digest(Digest.Algorithm.MD5);
        Assert.assertEquals("68e109f0f40ca72a15e05cc22786f8e6", md5.getHex("HelloWorld"));
        Assert.assertEquals("1ad3f9663cb9fb09d14f6119010f0f64", md5.getHex("TakWolf"));
        Assert.assertEquals("8b36e9207c24c76e6719268e49201d94", md5.getHex("Google"));
        Assert.assertEquals("bf4fef9f779d426de14d26f406aafc30", md5.getHex("今天的风儿有点喧嚣"));
        Assert.assertEquals("896c87c2017e74cf8c7ccf42d339ca66", md5.getHex("おはよう"));
        Assert.assertEquals("d5123f1e7c74c73a35fadc60fa92f011", md5.getHex("http://takwolf.com"));
    }

    @Test
    public void testSHA256() {
        Digest sha256 = new Digest(Digest.Algorithm.SHA256);
        Assert.assertEquals("872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4", sha256.getHex("HelloWorld"));
        Assert.assertEquals("b7fc98718fd0471db6d076794e10ae565421765db8f7e0fbcde9255c9799ceea", sha256.getHex("TakWolf"));
        Assert.assertEquals("ce770667e5f9b0d8f55367bb79419689d90c48451bb33f079f3a9a72ae132de8", sha256.getHex("Google"));
        Assert.assertEquals("9dd3eb3e3c6a0293f8fd15ba821b0e82e02f5dd93401fbf2401eda3a86101ff6", sha256.getHex("今天的风儿有点喧嚣"));
        Assert.assertEquals("4314662c3426676a1dd586be6a6f1bddf8dae143c7e8514c50af525f9dc6cec8", sha256.getHex("おはよう"));
        Assert.assertEquals("5fa3b877455bb494d8ef136126bfd25b21800fe205951ae872f87f0df6040df4", sha256.getHex("http://takwolf.com"));
    }

    @Test
    public void testSHA384() {
        Digest sha384 = new Digest(Digest.Algorithm.SHA384);
        Assert.assertEquals("293cd96eb25228a6fb09bfa86b9148ab69940e68903cbc0527a4fb150eec1ebe0f1ffce0bc5e3df312377e0a68f1950a", sha384.getHex("HelloWorld"));
        Assert.assertEquals("3488018b77d220fd1d63fb92361681b666334926ce691f92ce4d6c0df5e2b095bf02bedbace6833f93b17ce0d6a0a547", sha384.getHex("TakWolf"));
        Assert.assertEquals("2af172307e1317b9c04187cc7f664e5ea7907df8523c409bc2f226ab05f3ca031a966d86db52bc3a3600bd97bd8f2e50", sha384.getHex("Google"));
        Assert.assertEquals("80c2d3514e92d18a7df0785d27025a8a4b121b43abe2df819ec5adef92901f53c74202f669c876994834a82b7126fbac", sha384.getHex("今天的风儿有点喧嚣"));
        Assert.assertEquals("80d0f438c05c1e965a418cb2f68663cc20c08fe3e6af517d1649a85f0f90994a9d8e739dd5f6798c6f9d2c2af6b3b491", sha384.getHex("おはよう"));
        Assert.assertEquals("f58ac67b41c3669e81094eab5ccd480bc01d6d0f82fe2b2175a76ecd0700f3ab8ef9dacddcdee0b54f51c81c0f7bb640", sha384.getHex("http://takwolf.com"));
    }

    @Test
    public void testSHA512() {
        Digest sha512 = new Digest(Digest.Algorithm.SHA512);
        Assert.assertEquals("8ae6ae71a75d3fb2e0225deeb004faf95d816a0a58093eb4cb5a3aa0f197050d7a4dc0a2d5c6fbae5fb5b0d536a0a9e6b686369fa57a027687c3630321547596", sha512.getHex("HelloWorld"));
        Assert.assertEquals("e1af1c474cca48f5da0d2a7c98ee65839a9a8d020092000ac1a459576a001572e4d61d1e79f3a51a7800be4f17a18a0a18924b48fc24598c160ddbc7530911fb", sha512.getHex("TakWolf"));
        Assert.assertEquals("973807e34fb710b43bafbe55ffcbc7ba91235ee1388e816cb91439d895bd28815734c9886e6ec68262ed8b39f93850e628ba637866726d1e7b726c5e090b0299", sha512.getHex("Google"));
        Assert.assertEquals("22d3e6dcf8326234927fbaa2241edcd788e92cb359ed8f8511b9d9d958bdf39d00620d9eab7d7e6b90a9f6a41541e2fe8c0a4ee34eff564596bd2c8032ce0aec", sha512.getHex("今天的风儿有点喧嚣"));
        Assert.assertEquals("aa90b530a43ed3ce6cf0ac884163be63ed16098f9a21efeb6e80d68d2966efc47097697c4225adee35b326ddb4d3a97e3e3974338cf9007c24b3dd0aa4c8ab22", sha512.getHex("おはよう"));
        Assert.assertEquals("47dfd35c4c7c0d18047cc31f0e7099eda584bf1d83e1030a5612b5db0de881c4c787ee6a31550aef66c50064767b4a40fa8e3db7be2c2d760763823328411d0a", sha512.getHex("http://takwolf.com"));
    }

}

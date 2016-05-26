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

import com.takwolf.util.codec.Crypt;
import com.takwolf.util.codec.Digest;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
/*
        System.out.println("----- Digest MD5 -----");

        Map<String, String> mapMD5 = new HashMap<>();
        mapMD5.put("HelloWorld", "68e109f0f40ca72a15e05cc22786f8e6");
        mapMD5.put("TakWolf", "1ad3f9663cb9fb09d14f6119010f0f64");
        mapMD5.put("Google", "8b36e9207c24c76e6719268e49201d94");
        mapMD5.put("今天的风儿有点喧嚣", "bf4fef9f779d426de14d26f406aafc30");
        mapMD5.put("おはよう", "896c87c2017e74cf8c7ccf42d339ca66");
        mapMD5.put("http://takwolf.com", "d5123f1e7c74c73a35fadc60fa92f011");

        for (String key : mapMD5.keySet()) {
            String ccValue = mapMD5.get(key);
            String myValue = Digest.MD5.getHex(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new AssertionError("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
            }
        }

        System.out.println("----- Digest SHA256 -----");

        Map<String, String> mapSHA256 = new HashMap<>();
        mapSHA256.put("HelloWorld", "872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4");
        mapSHA256.put("TakWolf", "b7fc98718fd0471db6d076794e10ae565421765db8f7e0fbcde9255c9799ceea");
        mapSHA256.put("Google", "ce770667e5f9b0d8f55367bb79419689d90c48451bb33f079f3a9a72ae132de8");
        mapSHA256.put("今天的风儿有点喧嚣", "9dd3eb3e3c6a0293f8fd15ba821b0e82e02f5dd93401fbf2401eda3a86101ff6");
        mapSHA256.put("おはよう", "4314662c3426676a1dd586be6a6f1bddf8dae143c7e8514c50af525f9dc6cec8");
        mapSHA256.put("http://takwolf.com", "5fa3b877455bb494d8ef136126bfd25b21800fe205951ae872f87f0df6040df4");

        for (String key : mapSHA256.keySet()) {
            String ccValue = mapSHA256.get(key);
            String myValue = Digest.SHA256.getHex(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new AssertionError("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
            }
        }

        System.out.println("----- Digest SHA384 -----");

        Map<String, String> mapSHA384 = new HashMap<>();
        mapSHA384.put("HelloWorld", "293cd96eb25228a6fb09bfa86b9148ab69940e68903cbc0527a4fb150eec1ebe0f1ffce0bc5e3df312377e0a68f1950a");
        mapSHA384.put("TakWolf", "3488018b77d220fd1d63fb92361681b666334926ce691f92ce4d6c0df5e2b095bf02bedbace6833f93b17ce0d6a0a547");
        mapSHA384.put("Google", "2af172307e1317b9c04187cc7f664e5ea7907df8523c409bc2f226ab05f3ca031a966d86db52bc3a3600bd97bd8f2e50");
        mapSHA384.put("今天的风儿有点喧嚣", "80c2d3514e92d18a7df0785d27025a8a4b121b43abe2df819ec5adef92901f53c74202f669c876994834a82b7126fbac");
        mapSHA384.put("おはよう", "80d0f438c05c1e965a418cb2f68663cc20c08fe3e6af517d1649a85f0f90994a9d8e739dd5f6798c6f9d2c2af6b3b491");
        mapSHA384.put("http://takwolf.com", "f58ac67b41c3669e81094eab5ccd480bc01d6d0f82fe2b2175a76ecd0700f3ab8ef9dacddcdee0b54f51c81c0f7bb640");

        for (String key : mapSHA384.keySet()) {
            String ccValue = mapSHA384.get(key);
            String myValue = Digest.SHA384.getHex(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new AssertionError("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
            }
        }

        System.out.println("----- Digest SHA512 -----");

        Map<String, String> mapSHA512 = new HashMap<>();
        mapSHA512.put("HelloWorld", "8ae6ae71a75d3fb2e0225deeb004faf95d816a0a58093eb4cb5a3aa0f197050d7a4dc0a2d5c6fbae5fb5b0d536a0a9e6b686369fa57a027687c3630321547596");
        mapSHA512.put("TakWolf", "e1af1c474cca48f5da0d2a7c98ee65839a9a8d020092000ac1a459576a001572e4d61d1e79f3a51a7800be4f17a18a0a18924b48fc24598c160ddbc7530911fb");
        mapSHA512.put("Google", "973807e34fb710b43bafbe55ffcbc7ba91235ee1388e816cb91439d895bd28815734c9886e6ec68262ed8b39f93850e628ba637866726d1e7b726c5e090b0299");
        mapSHA512.put("今天的风儿有点喧嚣", "22d3e6dcf8326234927fbaa2241edcd788e92cb359ed8f8511b9d9d958bdf39d00620d9eab7d7e6b90a9f6a41541e2fe8c0a4ee34eff564596bd2c8032ce0aec");
        mapSHA512.put("おはよう", "aa90b530a43ed3ce6cf0ac884163be63ed16098f9a21efeb6e80d68d2966efc47097697c4225adee35b326ddb4d3a97e3e3974338cf9007c24b3dd0aa4c8ab22");
        mapSHA512.put("http://takwolf.com", "47dfd35c4c7c0d18047cc31f0e7099eda584bf1d83e1030a5612b5db0de881c4c787ee6a31550aef66c50064767b4a40fa8e3db7be2c2d760763823328411d0a");

        for (String key : mapSHA512.keySet()) {
            String ccValue = mapSHA512.get(key);
            String myValue = Digest.SHA512.getHex(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new AssertionError("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
            }
        }
*/

        System.out.println("----- Crypt -----");

        List<String> listText = new ArrayList<>();
        listText.add("HelloWorld");
        listText.add("TakWolf");
        listText.add("Google");
        listText.add("今天的风儿有点喧嚣");
        listText.add("おはよう");
        listText.add("http://takwolf.com");

        String uuid = "58e00488-2014-4947-ab29-40cfa1f0d692";

        System.out.println("----- AES -----");

        String keyAES = Digest.SHA1.getHex(uuid).substring(0, 16);
        String ivAES = Digest.MD5.getHex(uuid).substring(0, 16);

        for (String text : listText) {
            String crypt = Crypt.AES.encrypt(keyAES, ivAES, text);
            if (Crypt.AES.decrypt(keyAES, ivAES, crypt).equals(text)) {
                System.out.println(text + " : " + crypt);
            } else {
                throw new AssertionError("crypt error : " + text);
            }
        }

        System.out.println("----- DESede -----");

        String keyDESede = Digest.SHA1.getHex(uuid).substring(0, 24);
        String ivDESede = Digest.MD5.getHex(uuid).substring(0, 8);

        for (String text : listText) {
            String crypt = Crypt.DESede.encrypt(keyDESede, ivDESede, text);
            if (Crypt.DESede.decrypt(keyDESede, ivDESede, crypt).equals(text)) {
                System.out.println(text + " : " + crypt);
            } else {
                throw new AssertionError("crypt error : " + text);
            }
        }

    }

}

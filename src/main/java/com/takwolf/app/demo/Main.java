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

import com.takwolf.util.codec.Digest;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

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
            String myValue = Digest.MD5.getMessage(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new RuntimeException("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
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
            String myValue = Digest.SHA256.getMessage(key);
            if (ccValue.equalsIgnoreCase(myValue)) {
                System.out.println(key + " : " + ccValue);
            } else {
                throw new RuntimeException("digest error : " + key + "\nc : " + ccValue + "\nm : " + myValue);
            }
        }

    }

}

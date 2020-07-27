package com.example.mylib;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import okio.ByteString;


public class MyClass {
    private static Object object = new Object();

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add("C");
        list.add("GO");
        list.add("C#");
        list.add(2);
        System.out.println(list);
    }

    private  void StringDecode(){
        String str = "Hello MR";
        ByteString bytestring = ByteString.encodeUtf8(str);
        System.out.println(bytestring);

        System.out.println(bytestring.base64());

        System.out.println(bytestring.md5());
    }

    private void TestMap() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("3", 3);
        map.put("hello", 4);
        map.put("hello2", 5);
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("----------------------");

        map.get("hello");
        map.get("hello2");
        map.get("3");
        map.get("hello");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("----------------------");
        map.put("4", 3);

        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private void RunThread() {
        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    int i = 0;
                    while (i++ != 100) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Mathf.Add();
                    }
                }

            }
        }.run();

        new Thread() {
            @Override
            public void run() {
//                synchronized (object){
                int i = 0;
                while (i++ != 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Mathf.Add();
                }
//                }

            }
        }.run();

    }
}
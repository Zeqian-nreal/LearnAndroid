package com.example.mylib;

public class Mathf{
    public static final String tag;
    public static int count = 0;

    static {
        tag = "";
    }

    public  Mathf(){

    }

    synchronized  public  static   void Add(){
        count++;
        System.out.println("Threadid:" + Thread.currentThread().getId() + " Get count:"+count);
    }
}

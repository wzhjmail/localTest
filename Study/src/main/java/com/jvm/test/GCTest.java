package com.jvm.test;

/**
 * @ClassName Main
 * @Description
 * @Author wzj
 * @Date 2021/1/12 19:09
 **/

public class GCTest {

    public static void main(String[] args) {
        byte[] m1 = new byte[2 * 1024 * 1024];
//        byte[] m2 = new byte[2 * 1024 * 1024];
//        byte[] m3 = new byte[2 * 1024 * 1024];
//        byte[] m4 = new byte[4 * 1024 * 1024];
        System.gc();
    }


}

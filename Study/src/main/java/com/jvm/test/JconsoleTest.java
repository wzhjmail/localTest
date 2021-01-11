package com.jvm.test;

import com.jvm.Demo;

import java.util.ArrayList;

/**
 * @ClassName JconsoleTest
 * @Description
 * @Author wzj
 * @Date 2021/1/10 15:49
 **/

public class JconsoleTest {


    public static void main(String[] args) throws Exception {
        //
        Thread.sleep(5000);

        ArrayList<Demo> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            list.add(new Demo());
        }
    }
}

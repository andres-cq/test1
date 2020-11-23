package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Test 1 HUAWEI");
        Runnable r1 = () -> System.out.println("Hello World 1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));


    }

    public static void process(Runnable r) {
        r.run();
    }
}

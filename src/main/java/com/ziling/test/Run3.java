package com.ziling.test;

public class Run3 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500000);
                    } catch (Exception e) {

                    }
                }
            }.start();
        }
    }
}

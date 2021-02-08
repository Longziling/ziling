package com.ziling.goodlife.exception;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("--------------------------------------");
            throw new TestException("testException", 1);
        } catch (RuntimeException tex) {
            System.out.println("**************************************");
            System.out.println(tex.getMessage());
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            if (tex instanceof TestException) {
                System.out.println(((TestException)tex).getCode());
            }

        }


    }
}

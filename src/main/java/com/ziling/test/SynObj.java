package com.ziling.test;

public class SynObj {

    public static synchronized void showA(){
        System.out.println("showA..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showB(){
        synchronized (this) {
            System.out.println("showB..");
        }
    }

    public void showC(){
        String s="1";
        synchronized (String.class) {
            System.out.println("showC..");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void showD() {
        System.out.println("showD..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showE(){
        synchronized (Object.class) {
            System.out.println("showE..");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        final SynObj sy=new SynObj();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showA();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showB();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showC();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showD();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showE();
            }
        }).start();
    }

//    public static synchronized void staticFunction()
//            throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            Thread.sleep(1000);
//            System.out.println("Static function running...");
//        }
//    }
//
//    public synchronized void function() throws InterruptedException {
//        for (int i = 0; i <3; i++) {
//            Thread.sleep(1000);
//            System.out.println("function running...");
//        }
//    }
//
//    public static void main(String[] args) {
//        final SynObj demo = new SynObj();
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    staticFunction();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    demo.function();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//    }

}

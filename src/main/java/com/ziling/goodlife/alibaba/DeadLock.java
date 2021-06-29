package com.ziling.goodlife.alibaba;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 1:23
 *
 * 实现一个死锁
 */
public class DeadLock {

    private Object objectA = new Object();

    private Object objectB = new Object();

    public void testA() {
        synchronized(objectA) {
            System.out.println("testA get objectA success");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(objectB) {
                System.out.println("testA get objectB success");
            }

        }
    }

    public void testB() {
        synchronized(objectB) {
            System.out.println("testB get objectB success");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(objectA) {
                System.out.println("testB get objectA success");
            }

        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.testA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.testB();
            }
        }).start();
    }


}


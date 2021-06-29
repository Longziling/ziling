package com.ziling.goodlife.jdk.concurrent.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore叫信号量 or 信号灯
 * Semaphore有两个目的，第一个目的是多个共享资源互斥使用，第二目的是并发线程数的控制
 */

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟厕所10个茅坑
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    // 获取锁资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 上厕所");
                    // 模拟人上厕所若干秒，然后让出坑位
                    Random random = new Random();
                    TimeUnit.MILLISECONDS.sleep((long) (random.nextDouble() * 3000) + 1000);
                    System.out.println(Thread.currentThread().getName() + " 上完厕所，让出坑位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁资源
                    semaphore.release();
                }
            }, "" + i + "号帅哥").start();
        }
    }

}
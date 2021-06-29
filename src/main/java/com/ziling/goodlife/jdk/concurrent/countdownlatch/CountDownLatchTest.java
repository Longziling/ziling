package com.ziling.goodlife.jdk.concurrent.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(3);
        Thread threadA = new Thread(new Customer(downLatch, "张三"));
        Thread threadB = new Thread(new Customer(downLatch, "李四"));
        Thread threadC = new Thread(new Customer(downLatch, "王五"));

        Thread threadD = new Thread(new Waitress(downLatch, "小花"));

        threadA.start();
        threadB.start();
        threadC.start();
        Thread.sleep(100);
        threadD.start();
    }

}

class Customer implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    public Customer(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            System.out.println(sdf.format(new Date()) + "  " + name + " 从家出门");
            Random random = new Random();
            Thread.sleep((long) (random.nextDouble() * 3000) + 1000);
            System.out.println(sdf.format(new Date()) + "  " + name + " 到达饭店");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            downLatch.countDown();
        }
    }
}


class Waitress implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    public Waitress(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            System.out.println(sdf.format(new Date()) + "  " + name + " 等待顾客");
            downLatch.await(2, TimeUnit.SECONDS);
            System.out.println(sdf.format(new Date()) + "  " + name + " 开始上菜");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
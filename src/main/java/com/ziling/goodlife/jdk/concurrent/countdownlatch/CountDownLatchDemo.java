package com.ziling.goodlife.jdk.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private CountDownLatch countDownLatch;

    private int low = 10;

    private int mid = 100;

    private int high = 200;

    private int test1;

    private int test2;

    private int add(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    private int sum(int a, int b) {
        return a + b;
    }

    public void deal() {

        countDownLatch = new CountDownLatch(2);

        new Thread (() -> {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "开始执行");
                test1 = add(low, mid);
                System.out.println(Thread.currentThread().getName() + "   " + test1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "线程A").start();

        new Thread (() -> {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "开始执行");
                test2 = add(mid + 1, high);
                System.out.println(Thread.currentThread().getName() + "   " + test2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "线程B").start();

        new Thread (() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                countDownLatch.await();
                int sum = sum(test1, test2);
                System.out.println(Thread.currentThread().getName() + "   " +  sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "线程C").start();

    }

    public static void main(String[] args) {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        countDownLatchDemo.deal();
    }



}

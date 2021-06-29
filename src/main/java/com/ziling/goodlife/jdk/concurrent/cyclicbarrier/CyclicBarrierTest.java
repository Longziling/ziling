package com.ziling.goodlife.jdk.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("大家都执行到这里啦");
            }
        });
        Thread threadA = new Thread(new CyclicRunner(cyclicBarrier, "运动员A"));
        Thread threadB = new Thread(new CyclicRunner(cyclicBarrier, "运动员B"));
        Thread threadC = new Thread(new CyclicRunner(cyclicBarrier, "运动员C"));

        threadA.start();
        threadB.start();
        threadC.start();
    }

}

class CyclicRunner implements Runnable {

    private CyclicBarrier cyclicBarrier;

    private String name;

    public CyclicRunner(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "准备");
            Random random = new Random();
            Thread.sleep((long) (random.nextDouble() * 3000) + 1000);
            cyclicBarrier.await();
            System.out.println(name + "开始");
            Thread.sleep((long) (random.nextDouble() * 3000) + 1000);
            cyclicBarrier.await();
            System.out.println(name + "结束");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
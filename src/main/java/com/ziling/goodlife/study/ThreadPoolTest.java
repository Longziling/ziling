package com.ziling.goodlife.study;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yipeng
 * @Date: 2021/6/22 21:26
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 50, 500,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(new Task());
        threadPoolExecutor.submit(new Task());

    }

}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
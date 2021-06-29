//package com.ziling.mianshi;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//import org.python.google.common.collect.Lists;
//
//import javafx.util.Pair;
//
///**
// * @Author: yipeng
// * @Date: 2021/6/19 16:00
// */
//public class Test {
//
//    public static final List<String> URL_LIST = new ArrayList<>(200);
//
//    private ThreadPoolExecutor executor;
//
//
//    public Pair<Boolean, List<String>> getTitleList (Integer count) {
//        Pair<Boolean, List<String>> result = new Pair<>();
//        CountDownLatch countDownLatch = new CountDownLatch(count);
////        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 50, 400, TimeUnit.MILLISECONDS, LinkedBlockingQueue, factory, deployE);
//        List<String> currentUrls = getCurrentUrlList(count);
//        List<String> resultList = Lists.newArrayList();
//        for (int i = 0; i < count; i++) {
//            executor.submit(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String url = currentUrls.get(i);
//                    getTitle(url, countDownLatch, resultList);
//                }
//            }));
//        }
//        try {
//            countDownLatch.await(500, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (resultList.size() == count) {
//
//            return
//        }
//        return resultList;
//    }
//
//    /**
//     * 该方法放到另一个类中，因为使用到异步注解
//     * @param url
//     * @param countDownLatch
//     * @param resultList
//     */
//    @Async
//    public void getTitle(String url, CountDownLatch countDownLatch, List<String> resultList) {
//        String title = null;
//        try {
//            resultList.add(sendToGetTitle(url));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            countDownLatch.countDown();
//        }
//    }
//
//    public List<String> getCurrentUrlList(Integer count) {
//        List<String> currentList = new ArrayList<>(count);
//        // 随机拿出50个不一样的url；
//        return currentList;
//    }
//
//
//
//}

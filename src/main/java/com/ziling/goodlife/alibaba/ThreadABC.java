//package com.ziling.goodlife.alibaba;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: yipeng
// * @Date: 2021/6/18 0:28
// *
// * 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
// * 请补充以下代码
// *
// * public class ThreadABC {
// *     public static void main(String[] args) {
// *         MajusculeABC maj = new MajusculeABC();
// *         Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
// *         Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
// *         Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
// *         t_a.start();
// *         t_b.start();
// *         t_c.start();
// *     }
// * }
// *
// * class MajusculeABC {
// * 请补充代码
// * }
// * class Thread_ABC implements Runnable {
// * 请补充代码
// * }
// */
//public class ThreadABC {
//    public static void main(String[] args) {
//        MajusculeABC maj = new MajusculeABC();
//        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
//        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
//        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
//        t_a.start();
//        t_b.start();
//        t_c.start();
//    }
//}
//
//class MajusculeABC {
//    private Integer time = 10;
//    private Integer currentTime = 0;
//    private List<Character> list = new ArrayList<>();
//
//    public void addList(Character character) {
//        list.add(character);
//    }
//
//    public synchronized void print(Character item) {
//        while (currentTime / list.size() != time) {
//            int i = currentTime % list.size();
//            if (list.get(i) == item) {
//                System.out.print(item);
//                currentTime++;
//                if (currentTime % list.size() == 0 ) {
//                    System.out.println();
//                }
//                notifyAll();
//            } else {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//
//}
//
//
//class Thread_ABC implements Runnable {
//
//    private MajusculeABC maj;
//    private Character item;
//
//    Thread_ABC(MajusculeABC maj, Character item) {
//        this.maj = maj;
//        this.item = item;
//        this.maj.addList(item);
//    }
//
//    @Override
//    public void run() {
//        maj.print(item);
//    }
//
//
//}

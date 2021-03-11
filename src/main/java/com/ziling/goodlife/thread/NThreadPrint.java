package com.ziling.goodlife.thread;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

public class NThreadPrint {

    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        Thread t_d = new Thread(new Thread_ABC(maj , 'D'));
        Thread t_e = new Thread(new Thread_ABC(maj , 'E'));
        Thread t_f = new Thread(new Thread_ABC(maj , 'F'));
        Thread t_g = new Thread(new Thread_ABC(maj , 'G'));
        t_a.start();
        t_b.start();
        t_c.start();
        t_d.start();
        t_e.start();
        t_f.start();
        t_g.start();
    }
}

@Data
class MajusculeABC {
    LinkedList<Character> list = new LinkedList();
    int idx = 0;
    int loopCountMax = 10000;
    int currentLoop = 0;

    ReentrantLock lock = new ReentrantLock();
    public Character currentChart() {
        int i = idx % list.size();
        if (i == 0 && idx != 0) {
            currentLoop++;
            idx = 0;
            if (currentLoop >= loopCountMax) {
                currentLoop = -1;
                System.out.println();
                return null;
            }
            System.out.println();
        }
        return list.get(i);
    }

    public void add(Character character) {
        list.add(character);
    }
}

@Data
class Thread_ABC implements Runnable {
    private MajusculeABC majusculeABC;
    private Character msg;

    public Thread_ABC(MajusculeABC majusculeABC, Character msg) {
        majusculeABC.add(msg);
        this.majusculeABC = majusculeABC;
        this.msg = msg;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        while (true) {
            synchronized (majusculeABC) {
                if (majusculeABC.currentLoop < 0) {
                    majusculeABC.notifyAll();
                    break;
                } else {
                    if (Objects.equals(majusculeABC.currentChart(), this.msg)) {
                        System.out.print(msg);
                        majusculeABC.idx++;
                    }
                    try {
                        majusculeABC.notify();
                        majusculeABC.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        System.out.println(System.currentTimeMillis() - a);
    }

//    @Override
//    public void run() {
//        long a = System.currentTimeMillis();
//        while (true) {
//            try {
//                if (majusculeABC.getLock().tryLock(3, TimeUnit.SECONDS)) {
//                    if (majusculeABC.currentLoop < 0) {
//                        break;
//                    } else {
//                        if (Objects.equals(majusculeABC.currentChart(), this.msg)) {
//                            System.out.print(msg);
//                            majusculeABC.idx++;
//                        }
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                majusculeABC.getLock().unlock();
//            }
//        }
//        System.out.println(System.currentTimeMillis() - a);
//    }






//    @Data
//    class MajusculeABC {
//        private List<Character> list = new LinkedList<>();
//
//
//        private int index = 0;
//
//
//        private int loop = 10;
//
//
//        private int currentLoop = 0;
//
//
//        public void add(Character msg) {
//            list.add(msg);
//        }
//
//
//        public void print(Character msg) {
//            if (index / list.size() > 0) {
//                index = index % list.size();
//                currentLoop++;
//            }
//            if (list.get(index % list.size()) == msg) {
//                index++;
//                System.out.println(msg);
//            }
//        }
//
//
//
//
//    }
//
//
//    @Data
//    class Thread_ABC implements Runnable {
//        private MajusculeABC majusculeABC;
//        private Character msg;
//
//
//        public Thread_ABC(MajusculeABC majusculeABC, Character msg) {
//            this.majusculeABC = majusculeABC;
//            this.msg = msg;
//            majusculeABC.add(msg);
//        }
//
//
//        @Override
//        public void run() {
//            while(true) {
//                synchronized (majusculeABC) {
//                    if (majusculeABC.getLoop() <= majusculeABC.getCurrentLoop()) {
//                        break;
//                    }
//                    majusculeABC.print(msg);
//                }
//            }
//
//
//        }
//
//
//    }





}
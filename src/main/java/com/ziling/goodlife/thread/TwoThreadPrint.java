package com.ziling.goodlife.thread;

public class TwoThreadPrint {

    public synchronized void printStr(int count,String str){
        String name = Thread.currentThread().getName();
        if("A".equals(str)){
            System.out.println(name+"-----"+"A");

        }else if("B".equals(str)){
            System.out.println(name+"-----"+"B");
        }
        try {
            notify();
            if(count!=5){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void main(String[] args){
        TwoThreadPrint testThread= new TwoThreadPrint();
        TwoThreadTestA threadA = new TwoThreadTestA(testThread);
        TwoThreadTestB threadB = new TwoThreadTestB(testThread);
        threadA.setPriority(1);
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadA.start();
        threadB.start();
//        try {
//            threadA.join();
//            threadB.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("交替打印完成");
    }


}

class TwoThreadTestA extends Thread {

    private TwoThreadPrint twoThreadPrint;
    public TwoThreadTestA(TwoThreadPrint twoThreadPrint){
        this.twoThreadPrint = twoThreadPrint;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            count++;
            twoThreadPrint.printStr(count, "A");
        }
        System.out.println("A 线程打完了");
    }
}

class TwoThreadTestB extends Thread {

    private TwoThreadPrint twoThreadPrint;
    public TwoThreadTestB(TwoThreadPrint twoThreadPrint){
        this.twoThreadPrint = twoThreadPrint;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            count++;
            twoThreadPrint.printStr(count, "B");
        }
        System.out.println("B 线程打完了");
    }
}
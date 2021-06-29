package com.ziling.goodlife.thread;

public class NThread {

    public static void main(String[] args) {
        MyService service = new MyService();

        MyThread a = new MyThread(service, "A", 1);
        MyThread b = new MyThread(service, "B", 2);
        MyThread c = new MyThread(service, "C", 3);
        MyThread d = new MyThread(service, "D", 4);

        a.setName("线程一");
        b.setName("线程二");
        c.setName("线程三");
        d.setName("线程四");

        a.start();
        b.start();
        c.start();
        d.start();

    }

}


class MyService {

    private ThreadLocal<Integer> printCountLocal = new ThreadLocal<>();

    private static int currentPrintPosition = 0;

    private static int finalPrintPosition = 0;

    synchronized public void printMethod1(String eachThreadPrintChar, Integer eachThreadPrintPosition) {
        printCountLocal.set(0);
        while (printCountLocal.get() < 3) {
            if (currentPrintPosition == 3) {
                currentPrintPosition = 0;
            }
            while (eachThreadPrintPosition - 1 % 3 != currentPrintPosition) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finalPrintPosition++;
            System.out.println(Thread.currentThread().getName() + " " + eachThreadPrintChar + " currentPrintPosition= " + currentPrintPosition
                    + " printCountLocal.get()= " + (printCountLocal.get() + 1) + " finalPrintPosition= " + (finalPrintPosition));
            currentPrintPosition++;
            printCountLocal.set(printCountLocal.get() + 1);
            this.notifyAll();
        }
    }

    synchronized public void printMethod(String eachThreadPrintChar, Integer eachThreadPrintPosition) {
        int a = 0;
        while (a < 3) {
            if (currentPrintPosition == 4) {
                currentPrintPosition = 0;
            }
            while (eachThreadPrintPosition - 1 % 4 != currentPrintPosition) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finalPrintPosition++;
            System.out.println(Thread.currentThread().getName() + " " + eachThreadPrintChar + " currentPrintPosition= " + currentPrintPosition
                    + " a= " + (a + 1) + " finalPrintPosition= " + (finalPrintPosition));
            currentPrintPosition++;
            a++;
            this.notifyAll();
        }
    }

}

class MyThread extends Thread {

    private MyService myService;

    private String eachThreadPrintChar;

    private Integer eachThreadPrintPosition;

    public MyThread(MyService service, String eachThreadPrintChar, Integer eachThreadPrintPosition) {
        super();
        this.myService = service;
        this.eachThreadPrintChar = eachThreadPrintChar;
        this.eachThreadPrintPosition = eachThreadPrintPosition;
    }

    @Override
    public void run() {
        myService.printMethod(eachThreadPrintChar, eachThreadPrintPosition);
    }


}
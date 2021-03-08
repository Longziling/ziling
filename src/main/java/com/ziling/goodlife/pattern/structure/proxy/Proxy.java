package com.ziling.goodlife.pattern.structure.proxy;

/**
 * 代理模式
 *
 * 现有打印机类，可以进行打印
 * 但是客户存在多个，为防止多个客户端同时调用打印机出现故障
 * 现增加打印机代理类，对多个请求进行同步处理
 *
 */
public class Proxy {

    public static void main(String[] args) {
        Printable proxy = new ProxyPrinter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                proxy.setPrinterName("Proxy1");
                proxy.print("Hello, my name is Black Jack.");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                proxy.setPrinterName("Proxy2");
                proxy.print("Hello, my name is Tom.");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                proxy.setPrinterName("Proxy3");
                proxy.print("Hello, my name is Bob.");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}

interface Printable {

    void setPrinterName(String name);

    String getPrinterName();

    void print(String word);
}

class Printer implements Printable {

    private String name;

    public Printer(String name) {
        this.name = name;
        heavyWork();
        System.out.println("printer create success!");
    }


    private void heavyWork() {
        System.out.println("current printer " + name);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String word) {
        System.out.println("printer" + name + " printing...");
        System.out.println(word);
        System.out.println("print success!");
    }
}

class ProxyPrinter implements Printable {

    private String name;

    private Printer printer;

    @Override
    public synchronized void setPrinterName(String name) {
        if (null != printer) {
            printer.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public synchronized void print(String word) {
        check();
        printer.print(word);
    }

    private void check() {
        if (null == printer) {
            printer = new Printer(name);
        }
    }

}

package com.ziling.goodlife.design.proxy;

public class Main {

    public static void main(String[] args) {
        Printable proxy = new ProxyPrinter();
        proxy.setPrinterName("zyp");
        System.out.println("此代理名字为： " + proxy.getPrinterName());
        System.out.println("遇到代理处理不了的工作，通知服务器");
        proxy.print("hello world");
        System.out.println("==========================");
        proxy.setPrinterName("lzl");
        System.out.println("此代理的名字为： " + proxy.getPrinterName());
        proxy.print("hello, my country!");
    }

}

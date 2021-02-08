package com.ziling.goodlife.design.proxy;

public class ProxyPrinter implements Printable {

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
    public void print(String word) {
        check();
        printer.print(word);
    }

    private synchronized void check() {
        if (null == printer) {
            printer = new Printer(name);
        }
    }
}

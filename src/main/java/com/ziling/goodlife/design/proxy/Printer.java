package com.ziling.goodlife.design.proxy;

public class Printer implements Printable {

    private String name;

    public Printer(String name) {
        this.name = name;
        heavyWork();
        System.out.println("生成打印机实例成功...");
    }


    private void heavyWork() {
        System.out.println("本机器： " + name);
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
        System.out.println("打印机" + name + "正在打印...");
        System.out.println(word);
        System.out.println("打印完成！");
    }
}

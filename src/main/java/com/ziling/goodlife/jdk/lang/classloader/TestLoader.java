package com.ziling.goodlife.jdk.lang.classloader;

public class TestLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader l1 = new MyClassLoader("loader1");
        Class dogC = l1.loadClass("Dog");
        dogC.newInstance();

        Dog dog = new Dog();

//		MyClassLoader l2 = new MyClassLoader("loader2",l1);  //把L1作为它的父加载器
//		Class doccc = l2.loadClass("Dog");
//		doccc.newInstance();
    }
}

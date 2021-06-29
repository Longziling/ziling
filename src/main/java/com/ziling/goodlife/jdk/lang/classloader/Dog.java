package com.ziling.goodlife.jdk.lang.classloader;

public class Dog {

    public Dog() {
        System.out.println(this.getClass().getClassLoader());
    }

}

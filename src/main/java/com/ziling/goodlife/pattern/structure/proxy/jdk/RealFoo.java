package com.ziling.goodlife.pattern.structure.proxy.jdk;

public class RealFoo implements Foo {

    @Override
    public String ping(String name) {
        System.out.println("ping");
        return "pong";
    }

}


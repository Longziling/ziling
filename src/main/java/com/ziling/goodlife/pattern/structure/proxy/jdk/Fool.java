package com.ziling.goodlife.pattern.structure.proxy.jdk;

public class Fool {

    public String ping(String name) {
        System.out.println("ping");
        return "pong";
    }

}

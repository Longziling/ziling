package com.ziling.goodlife.design.composite;

public class Leaf2 implements Component2 {

    private String name;

    public Leaf2(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("安全式--叶子： " + name + " 被访问");
    }
}

package com.ziling.goodlife.pattern.behavior.observer;

public class Subscriber1 implements Observer {

    public Subscriber1() {}

    @Override
    public void update(String edition) {
        System.out.println("Subscriber1收到新的版本通知。" + edition);
    }
}

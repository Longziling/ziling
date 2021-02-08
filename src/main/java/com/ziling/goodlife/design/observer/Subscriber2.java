package com.ziling.goodlife.design.observer;

public class Subscriber2 implements Observer {

    public Subscriber2(){}

    @Override
    public void update(String edition) {
        System.out.println("Subscriber2收到新的版本通知。" + edition);
    }
}

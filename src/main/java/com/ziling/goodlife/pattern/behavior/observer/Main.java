package com.ziling.goodlife.pattern.behavior.observer;

public class Main {

    public static void main(String[] args) {
        // 主体
        Subject publisher = new Publisher();
        publisher.initObservers();

        // 观察者注册
        Observer subscriber1 = new Subscriber1();
        publisher.registerObserver(subscriber1);

        Observer subscriber2= new Subscriber2();
        publisher.registerObserver(subscriber2);

        // 通知当前已注册的观察者
        publisher.notifyObservers();

        // 移除观察者
        publisher.removeObserver(subscriber2);

        // 通知当前已注册的观察者
        publisher.notifyObservers();

    }
}

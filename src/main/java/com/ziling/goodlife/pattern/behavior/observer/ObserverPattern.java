package com.ziling.goodlife.pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
 *
 */
public class ObserverPattern {

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

interface Observer {
    void update(String observer);
}

/**
 * 主体
 */
interface Subject {

    /**
     * 注册主体
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除订阅
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 移除所有的观察者
     */
    void notifyObservers();

    /**
     * 初始化主体相关信息
     */
    void initObservers();
}

class Publisher implements Subject{

    /**
     * 已注册的观察者列表
     */
    List<Observer> observerList = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        System.out.println("注册观察者:" + observer);
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        System.out.println("注销观察者:" + observer);
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update("广播消息给：" + observer);
        }
    }

    @Override
    public void initObservers() {
        if (null == observerList) {
            observerList = new ArrayList<>();
        }
    }
}


class Subscriber1 implements Observer {

    public Subscriber1() {}

    @Override
    public void update(String edition) {
        System.out.println("Subscriber1收到新的版本通知。" + edition);
    }
}

class Subscriber2 implements Observer {

    public Subscriber2(){}

    @Override
    public void update(String edition) {
        System.out.println("Subscriber2收到新的版本通知。" + edition);
    }
}



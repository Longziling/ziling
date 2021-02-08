package com.ziling.goodlife.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Subject{

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

package com.ziling.test;

import java.util.ArrayList;
import java.util.List;

public class DesignTest {

    public static void main(String[] args) {
        List<Common> list = new ArrayList<>(4);
        Cat cat = new Cat();
        Dog dog = new Dog();
        CommonDecorator redCat = new RedCommonDecorator(new Cat());
        CommonDecorator redDog = new RedCommonDecorator(new Dog());
        list.add(cat);
        list.add(dog);
        list.add(redCat);
        list.add(redDog);
        for (Common common : list) {
            common.print();
        }
    }

}

interface Common {
    void print();
}


class Cat implements Common {
    @Override
    public void print() {
        System.out.println("this is cat");
    }
}

class Dog implements Common {
    @Override
    public void print() {
        System.out.println("this is dog");
    }
}

abstract class CommonDecorator implements Common {
    protected Common decoratedCommon;
    public CommonDecorator(Common common) {
        this.decoratedCommon = common;
    }

    public void print(){
        decoratedCommon.print();
    }
}

class RedCommonDecorator extends CommonDecorator {
    public RedCommonDecorator(Common decoratedCommon) {
        super(decoratedCommon);
    }
    @Override
    public void print() {
        decoratedCommon.print();
        setRed(decoratedCommon);
    }

    void setRed(Common decoratedCommon) {
        System.out.println("Color : Red");
    }
}

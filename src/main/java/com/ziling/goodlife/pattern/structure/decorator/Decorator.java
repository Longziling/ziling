package com.ziling.goodlife.pattern.structure.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * 装饰着模式
 * 适用于给原有类增加装饰的场景
 * 例如：1. 动物有猫或者狗。现在需要对毛皮颜色进行输出，
 *      2. 买奶茶时，需要加冰，加珍珠，加糖等
 *      3. jdk中流处理的类等
 */
public class Decorator {

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>(4);
        Cat cat = new Cat();
        Dog dog = new Dog();
        AnimalDecorator whiteCat = new WhiteCommonDecorator(new Cat());
        AnimalDecorator whiteDog = new WhiteCommonDecorator(new Dog());
        list.add(cat);
        list.add(dog);
        list.add(whiteCat);
        list.add(whiteDog);
        for (Animal common : list) {
            common.print();
        }
    }

}

interface Animal {
    void print();
}


class Cat implements Animal {
    @Override
    public void print() {
        System.out.println("this is cat");
    }
}

class Dog implements Animal {
    @Override
    public void print() {
        System.out.println("this is dog");
    }
}

abstract class AnimalDecorator implements Animal {
    protected Animal decoratedAnimal;
    public AnimalDecorator(Animal decoratedAnimal) {
        this.decoratedAnimal = decoratedAnimal;
    }
}

class WhiteCommonDecorator extends AnimalDecorator {
    public WhiteCommonDecorator(Animal decoratedCommon) {
        super(decoratedCommon);
    }
    @Override
    public void print() {
        decoratedAnimal.print();
        setWhite(decoratedAnimal);
    }

    void setWhite(Animal decoratedAnimal) {
        System.out.println("Fur Color : White");
    }
}

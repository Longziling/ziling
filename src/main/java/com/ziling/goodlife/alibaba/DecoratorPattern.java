package com.ziling.goodlife.alibaba;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 0:08
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Price coffee = new Coffee();
        System.out.println(coffee.price());
        Price milk = new Milk(coffee);
        System.out.println(milk.price());
        Price sugar = new Sugar(milk);
        System.out.println(sugar.price());
        Price sugar1 = new Sugar(sugar);
        System.out.println(sugar1.price());
    }

}

interface Price {
    Integer price();
}

class Coffee implements Price{

    private Price priceImpl;

    public Coffee() {}

    public Coffee(Price priceImpl) {
        this.priceImpl = priceImpl;
    }

    @Override
    public Integer price() {
        return priceImpl == null ? 10 : priceImpl.price() + 10;
    }

}

class Milk implements Price{

    private Price priceImpl;

    public Milk(){}

    public Milk(Price priceImpl) {
        this.priceImpl = priceImpl;
    }

    @Override
    public Integer price() {
        return priceImpl == null ? 8 : priceImpl.price() + 8;
    }

}

class Sugar implements Price{

    private Price priceImpl;

    public Sugar(){}

    public Sugar(Price priceImpl) {
        this.priceImpl = priceImpl;
    }

    @Override
    public Integer price() {
        return priceImpl == null ? 3 : priceImpl.price() + 3;
    }


}



package com.ziling.goodlife.design.builder;

public class CheapBuilder implements Builder {
    Car cheapCar = new Car();

    @Override
    public void buildWheel() {
        cheapCar.setWheel("cheap wheel");
    }

    @Override
    public void buildFrame() {
        cheapCar.setFrame("cheap frame");
    }

    @Override
    public void buildEngine() {
        cheapCar.setEngine("cheap engine");
    }

    @Override
    public void buildWidget() {
        cheapCar.setWidget("no widget");
    }

    @Override
    public Car getCar() {
        return cheapCar;
    }
}

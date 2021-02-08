package com.ziling.goodlife.design.builder;

public class EconomicBuilder implements Builder {

    Car economicCar = new Car();

    @Override
    public void buildWheel() {
        economicCar.setWheel("cheap wheel");
    }

    @Override
    public void buildFrame() {
        economicCar.setFrame("expensive frame");
    }

    @Override
    public void buildEngine() {
        economicCar.setEngine("cheap engine");
    }

    @Override
    public void buildWidget() {
        economicCar.setWidget("economic widget");
    }

    @Override
    public Car getCar() {
        return economicCar;
    }
}

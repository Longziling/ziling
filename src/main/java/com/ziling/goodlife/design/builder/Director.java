package com.ziling.goodlife.design.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void produceCar() {
        builder.buildFrame();
        builder.buildWidget();
        builder.buildWheel();
        builder.buildEngine();
    }

    public Car getCar() {
        return builder.getCar();
    }
}

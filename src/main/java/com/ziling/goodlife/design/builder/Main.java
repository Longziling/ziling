package com.ziling.goodlife.design.builder;

public class Main {

    public static void main(String[] args) {
        Builder bld = new EconomicBuilder();
        Director director = new Director(bld);
        director.produceCar();
        Car car = director.getCar();
        System.out.println(car);
    }

}

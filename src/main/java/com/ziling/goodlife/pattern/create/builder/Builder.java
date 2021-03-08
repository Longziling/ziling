package com.ziling.goodlife.pattern.create.builder;

public class Builder {

    public static void main(String[] args) {
        BuilderPlan bld = new EconomicBuilder();
        Director director = new Director(bld);
        director.produceCar();
        Car car = director.getCar();
        System.out.println(car.toString());
    }

}

interface BuilderPlan {

    void buildWheel();

    void buildFrame();

    void buildEngine();

    void buildWidget();

    Car getCar();

}

class CheapBuilder implements BuilderPlan {
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

class EconomicBuilder implements BuilderPlan {

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


interface CarPlan {

    void setWheel(String wheel);

    void setFrame(String frame);

    void setEngine(String engine);

    void setWidget(String widget);

}

class Car implements CarPlan {

    private String myWheel;

    private String myFrame;

    private String myEngine;

    private String myWidget;

    @Override
    public void setWheel(String wheel) {
        this.myWheel = wheel;
    }

    @Override
    public void setFrame(String frame) {
        this.myFrame = frame;
    }

    @Override
    public void setEngine(String engine) {
        this.myEngine = engine;
    }

    @Override
    public void setWidget(String widget) {
        this.myWidget = widget;
    }
}

class Director {

    private BuilderPlan builder;

    public Director(BuilderPlan builder) {
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


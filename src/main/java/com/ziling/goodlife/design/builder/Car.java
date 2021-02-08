package com.ziling.goodlife.design.builder;

public class Car implements CarPlan {

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

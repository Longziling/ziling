package com.ziling.goodlife.design.decorator;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShap;

    public ShapeDecorator(Shape decoratedShap) {
        this.decoratedShap = decoratedShap;
    }

    public void draw() {
        decoratedShap.draw();
    }

}

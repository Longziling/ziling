package com.ziling.goodlife.pattern.structure.decorator;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShap;

    public ShapeDecorator(Shape decoratedShap) {
        this.decoratedShap = decoratedShap;
    }

    public void draw() {
        decoratedShap.draw();
    }

}

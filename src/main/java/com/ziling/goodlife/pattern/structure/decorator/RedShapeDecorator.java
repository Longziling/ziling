package com.ziling.goodlife.pattern.structure.decorator;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShap) {
        super(decoratedShap);
    }

    @Override
    public void draw() {
        decoratedShap.draw();
        setRedBorder(decoratedShap);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color : Red");
    }
}

package com.ziling.goodlife.pattern.structure.decorator;

public class GreenShapeDecorator implements ShapeDecoratorImpl {

    private Shape shapeDecorator;

    public GreenShapeDecorator(Shape shapeDecorator) {
        this.shapeDecorator = shapeDecorator;
    }


    @Override
    public void draw() {
        shapeDecorator.draw();
        setGreenBorder(shapeDecorator);
    }

    private void setGreenBorder(Shape decoratedShape) {
        System.out.println("Border Color : Green");
    }
}

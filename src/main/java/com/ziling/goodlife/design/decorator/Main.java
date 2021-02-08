package com.ziling.goodlife.design.decorator;

public class Main {
    public static void main1(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }

    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecoratorImpl greenCircle = new GreenShapeDecorator(new Circle());
        ShapeDecoratorImpl greenRectangle = new GreenShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of green border");
        greenCircle.draw();

        System.out.println("\nRectangle of green border");
        greenRectangle.draw();
    }
}

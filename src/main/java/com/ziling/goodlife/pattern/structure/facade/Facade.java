package com.ziling.goodlife.pattern.structure.facade;

/**
 * 外观/门面模式
 *
 * 隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
 *
 */
public class Facade {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}


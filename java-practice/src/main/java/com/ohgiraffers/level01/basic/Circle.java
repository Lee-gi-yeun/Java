package com.ohgiraffers.level01.basic;

public class Circle extends Shape implements Resizable{

    public static final double PI = Math.PI;
    private double radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return radius * radius * PI;
    }

    @Override
    double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public void resize(double factor) {
        this.radius = factor*radius;
    }
}

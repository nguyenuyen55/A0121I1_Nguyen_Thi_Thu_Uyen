package keThua.thucHanh;

import abstractAndInterface.baiTap.interfaceChoResizeable.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {
        this.radius=1.0;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return Math.PI*2*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                  ", which is a subclass of "+super.toString() +'}';
    }

    @Override
    public void resize(double percent) {
        this.radius +=this.radius*percent/100;
    }
}

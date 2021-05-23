package keThua.thucHanh;

import abstractAndInterface.baiTap.interfaceChoResizeable.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double length;

    public Rectangle() {
        this.width=1.0;
        this.length=1.0;
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return width+length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                "which is a subclass of "+super.toString()+'}';
    }

    @Override
    public void resize(double percent) {
        this.length +=this.length*percent/100;
        this.width +=this.width*percent/100;
    }
}

package keThua.thucHanh;

import abstractAndInterface.baiTap.interfaceChoColorable.Colorable;
import abstractAndInterface.baiTap.interfaceChoResizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }
    public Square(double side) {
        super(side,side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }



    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }
    public double getArea(){
        return getSide()*getSide();
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.setSide(this.getSide()+this.getSide()*percent/100);
    }

    @Override
    public void howToColor() {
        System.out.println("color all four sides..");
    }
}
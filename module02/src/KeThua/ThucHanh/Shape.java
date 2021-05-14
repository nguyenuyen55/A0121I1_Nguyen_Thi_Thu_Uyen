package KeThua.ThucHanh;

import AbstractAndInterface.BaiTap.InterfaceChoColorable.Colorable;
import AbstractAndInterface.BaiTap.InterfaceChoResizeable.Resizeable;

public class Shape implements Resizeable, Colorable {
    private String color;
    private boolean filled;

    public Shape() {
        this.color="green";
        this.filled=true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public double getArea(){
        return 0;
    }
    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    @Override
    public void resize(double percent) {
        return;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides...");
    }
}

package abstractAndInterface.baiTap.interfaceChoResizeable;

import keThua.thucHanh.Circle;
import keThua.thucHanh.Rectangle;
import keThua.thucHanh.Shape;
import keThua.thucHanh.Square;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Square(3);
        shapes[2] = new Rectangle();
        System.out.println("before increase percent");
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " " + shape.getArea());
        }
        for (Shape shape : shapes) {
            shape.resize(Math.floor(Math.random() * 100 + 1));
        }
        System.out.println("after increase percent");
        for (Shape shape : shapes) {
            System.out.println(" " + shape.getArea());
        }
    }
}

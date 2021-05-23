package abstractAndInterface.baiTap.interfaceChoColorable;

import keThua.thucHanh.Circle;
import keThua.thucHanh.Rectangle;
import keThua.thucHanh.Shape;
import keThua.thucHanh.Square;

public class Demo {

    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0] =new Square();
        shapes[1] =new Circle();
        shapes[2] =new Rectangle(3,2);

        for (Shape x : shapes) {
            if(x instanceof Colorable){
                ( (Colorable) x).howToColor();
                continue;
            }
            System.out.println(x.getArea());

        }
    }
}

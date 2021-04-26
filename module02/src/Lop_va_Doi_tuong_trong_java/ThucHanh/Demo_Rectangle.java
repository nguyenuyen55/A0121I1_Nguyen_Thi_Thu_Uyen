package Lop_va_Doi_tuong_trong_java.ThucHanh;

import java.util.Scanner;

public class Demo_Rectangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //nhap chieu dai
        System.out.println("nhap chieu dai ");
        double height=scanner.nextDouble();
        //nhap chieu rong
        System.out.println("nhap chieu rong ");
        double width=scanner.nextDouble();
        //khoi tao class
        Rectangle rectangle=new Rectangle(width,height);
        System.out.println("your rectangle : "+rectangle.display());
        System.out.println("area rectangle : "+rectangle.getArea());
        System.out.println("perimeter rectangle : "+rectangle.getPerimeter());

    }
}

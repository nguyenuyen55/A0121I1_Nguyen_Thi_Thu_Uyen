package lop_va_Doi_tuong_trong_java.baiTap;

import java.util.Scanner;

public class Demo_quadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("phương trình bậc 2 có dạng ax^2 + bx + c=0");

        System.out.println("nhập a : ");
        double a=scanner.nextDouble();
        System.out.println("nhập b : ");
        double b=scanner.nextDouble();
        System.out.println("nhập c : ");
        double c=scanner.nextDouble();
        //khoi tao doi tuong phương trình bậc 2
        QuadraticEquation pt2=new QuadraticEquation(a,b,c);
        System.out.println(pt2.getDiscriminant());
        if(pt2.getDiscriminant()>0){
            System.out.println("pt có hai nghiệm ");
            System.out.println("x1 = "+pt2.getRoot1());
            System.out.println("x2 = "+pt2.getRoot2());
        }else if(pt2.getDiscriminant()==0){
            System.out.println("pt có ngiệm kép : ");
            System.out.println("x = "+pt2.getRoot1());
        }else {
            System.out.println("The equation has no roots");
        }

    }
}

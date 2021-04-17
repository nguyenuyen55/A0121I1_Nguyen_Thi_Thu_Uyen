package Introduction_to_java.thuchanh;

import java.util.Scanner;

public class Su_dung_toan_tu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("tính diện tích hình chữ nhật ");
        System.out.println("nhập chiều rộng hcn:");
        double width=sc.nextDouble();
        System.out.println("nhập chiều cao hcn: ");
        double height=sc.nextDouble();
        System.out.println("diện tích hcn là : "+width*height);
    }
}

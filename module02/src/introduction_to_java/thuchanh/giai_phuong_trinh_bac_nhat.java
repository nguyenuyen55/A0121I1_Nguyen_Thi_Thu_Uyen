package introduction_to_java.thuchanh;

import java.util.Scanner;

public class giai_phuong_trinh_bac_nhat {
    public static void main(String[] args) {
        //bài toán giải phương trình bậc nhất ax+b;
        Scanner sc=new Scanner(System.in);
        System.out.println("phương trình bậc nhất có dạng :ax + b=0");
        System.out.println("nhập a :");
        double a=sc.nextDouble();
        System.out.println("nhập b");
        double b=sc.nextDouble();
        System.out.println("pt có dạng : "+a+"x+ "+b+" = 0");
        if(a!=0){

            System.out.println("pt có nghiệm : "+(-b/a));
        }else {
            System.out.println("phương trình vô nghiệm");
        }

    }
}

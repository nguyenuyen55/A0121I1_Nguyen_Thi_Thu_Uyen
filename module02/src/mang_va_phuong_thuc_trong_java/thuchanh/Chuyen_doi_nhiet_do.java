package mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class Chuyen_doi_nhiet_do {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int choice ;
        double kq;
        do {
            System.out.println("1. chuyển từ f sang c");
            System.out.println("2. chuyển từ c sang f");
            System.out.println("3. exit");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("nhập f :");
                    double f=input.nextDouble();
                    kq=(5.0 / 9) * (f - 32);
                    System.out.println("f chuyen qua c là "+kq);
                    break;
                case 2:
                    System.out.println("nhập c:");
                    double c=input.nextDouble();
                    kq=(9.0 / 5) * c + 32;
                    System.out.println("c chuyen qua f là "+kq);
                    break;

            }

        }while (choice<3);


    }
}

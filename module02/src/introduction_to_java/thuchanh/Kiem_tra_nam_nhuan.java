package introduction_to_java.thuchanh;

import java.util.Scanner;

public class Kiem_tra_nam_nhuan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập năm muốn kiểm tra :");
        int nam=sc.nextInt();
        if((nam % 4 == 0 && nam % 100 !=0)|| (nam % 400 == 0 && nam % 100 ==0)) {
            System.out.println("năm nhuận");
        }else {
            System.out.println("không phải năm nhuận");
        }
    }

}

package introduction_to_java.thuchanh;

import java.util.Scanner;

public class Ngay_trong_thang {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập tháng :");
        int thang = sc.nextInt();
        while (thang>12 ||thang<1){
            System.out.println("tháng không hợp lệ vui lòng nhập lại :");
            thang=sc.nextInt();
        }
        switch (thang){
            case 1 : case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("có 31 ngày ");
                break;
            case 2:
                System.out.println("có 28 hoặc 29 ngày");break;
            default:
                System.out.println("có 30 ngày ");
        }
    }
}

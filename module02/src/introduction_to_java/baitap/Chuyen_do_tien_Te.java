package introduction_to_java.baitap;

import java.util.Scanner;

public class Chuyen_do_tien_Te {
    public static void main(String[] args) {
        //bài toán chuyển đổi tiền tệ
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập số tiền (usa) :");
        double usa=sc.nextDouble();
        System.out.println("chuyển qua tiền việc nam là : "+usa*25000  );
    }
}

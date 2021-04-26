package Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Dem_ki_tu_trong_chuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] s = {"a", "e", "n", "h", "g", "h", "e", "n", "a"};
        String kq = "";
        for (int i = 0; i < s.length; i++) {
            kq += s[i];
        }
        System.out.println("chuỗi string : " + kq);
        System.out.println("nhập kí tự cần đếm :");
        String kitu = input.nextLine();
        int dem = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(kitu)) {
                dem++;
            }
        }
        System.out.println("kí tự này xuất hiện " + dem + " lan");

    }

}

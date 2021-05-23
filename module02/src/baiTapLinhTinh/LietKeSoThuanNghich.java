package baiTapLinhTinh;

import java.util.Scanner;

public class LietKeSoThuanNghich {
    public static int numberDaoNguoc(int num) {
       int  reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int dem = 0;
        String kq = "";
        for (int i = 0; i < arr.length; i++) {
            if (numberDaoNguoc(arr[i])==arr[i]) {
                dem++;
                kq += (arr[i] + " ");
            }
        }
        System.out.println(dem);
        System.out.println(kq);
    }
}

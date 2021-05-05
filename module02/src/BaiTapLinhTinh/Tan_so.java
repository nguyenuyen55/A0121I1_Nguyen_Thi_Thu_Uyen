package BaiTapLinhTinh;

import java.util.Scanner;

public class Tan_so {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int dem = 0;
        int x = sc.nextInt();
        for (int a : arr) {
            if (a == x) {
                dem++;
            }
        }
        System.out.println(dem);
    }
}

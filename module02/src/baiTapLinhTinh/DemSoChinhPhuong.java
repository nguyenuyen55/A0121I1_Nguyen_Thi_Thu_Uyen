package baiTapLinhTinh;

import java.util.Scanner;

public class DemSoChinhPhuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
        int sum = 0;

        for (double a : arr) {
            sum += a;
        }
        double kq=(float)sum/n;
       // System.out.printf("%.3f",(float)(sum/n));
        System.out.printf("%.3f",kq);
    }
}

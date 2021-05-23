package mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Tong_2_duong_cheo {
    public static void nhapMang(int[][] arr, int sodong, int soCot) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.println("nhập phân tử [" + (i) + "][" + j + " ]:");
                arr[i][j] = input.nextInt();
            }
        }
    }

    public static void xuatMang(int[][] arr, int sodong, int soCot) {

        for (int i = 0; i < sodong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void tongDuongCheo(int[][] arr, int sodong, int soCot) {
        int sum = 0;
        for (int i = 0; i < sodong; i++) {
            sum += arr[i][i];
            sum += arr[i][sodong - 1 - i];
        }
        System.out.println("tổng của mảng hai chiều " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số dòng : ");
        int sodong = sc.nextInt();

        int soCot;
        do {
            System.out.println("nhập số cột : ");
            soCot = sc.nextInt();
            if (soCot != sodong) {
                System.out.println("số cột phải bằng số dòng vui lòng nhập lại");
            }
        } while (soCot != sodong);


        int[][] arr = new int[sodong][soCot];
        nhapMang(arr, sodong, soCot);
        //xuat mang
        xuatMang(arr, sodong, soCot);
        tongDuongCheo(arr, sodong, soCot);

    }
}

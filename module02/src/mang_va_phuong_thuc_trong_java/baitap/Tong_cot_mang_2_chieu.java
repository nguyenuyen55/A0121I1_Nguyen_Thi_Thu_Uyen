package mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Tong_cot_mang_2_chieu {
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

    public static void tongCot(int[][] arr, int sodong, int soCot, int cotTong) {

        int sum = 0;

        for (int i = 0; i < soCot; i++) {
            if (i == cotTong) {
                for (int j = 0; j < sodong; j++) {
                    sum += arr[j][i];
                }
            }
        }
        System.out.println("tong giá trị ở cột " + cotTong + " là " + sum);

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số dòng : ");
        int sodong = input.nextInt();
        System.out.println("nhập số cột : ");
        int soCot = input.nextInt();

        int[][] arr = new int[sodong][soCot];
        nhapMang(arr, sodong, soCot);
        //xuat mang
        xuatMang(arr, sodong, soCot);
        System.out.println("nhập số cột muốn tính tổng : ");
        int soCotTong = input.nextInt();

        tongCot(arr, sodong, soCot, soCotTong);
/*
*


    public static void maxMang(int[][] arr,int sodong,int soCot){
        int max=arr[0][0];
        int vtcot = 0;
        int vtdong=0;
        for (int i = 0; i <sodong ; i++) {
            for (int j = 0; j <soCot ; j++) {
                if(arr[i][j]>max){
                    max=arr[i][j];
                    vtcot=i;
                    vtdong=j;
                }
            }
        }
        System.out.println("vị trí ["+vtdong+"]["+vtcot+"] có giá trị "+max+" là giá trị lớn nhất ");

    }


    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("nhập số hang : ");
        int soHang=input.nextInt();
        System.out.println("nhập số cột : ");
        int soCot=input.nextInt();
        int[][] arr=new int[soHang][soCot];
        nhapMang(arr,soHang,soCot);
        //xuat mang
       xuatMang(arr,soHang,soCot);
maxMang(arr,soHang,soCot);
    }*/
    }
}

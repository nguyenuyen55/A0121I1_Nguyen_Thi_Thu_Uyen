package mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class Ung_dung_dem_sv_dau {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size;
        int[] arr;
        do {
            System.out.println("nhập số lượng sinh viên: ");
            size=scanner.nextInt();
            if(size>30){
                System.out.println("số lượng sinh viên không được quá 30 ");
            }
        }while (size>30);
        arr= new int[size];
        int i=0;
        while (i<arr.length){
            System.out.print("nhập điểm của sv "+(i+1)+" :");
            arr[i]=scanner.nextInt();
            i++;
        }
        int dem=0;
        System.out.println("danh sách điểm sv");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
            if(arr[j]>=5 &&arr[j]<=10){
                dem++;
            }
        }
        System.out.println("tổng sinh viên qua môn "+dem);
    }
}

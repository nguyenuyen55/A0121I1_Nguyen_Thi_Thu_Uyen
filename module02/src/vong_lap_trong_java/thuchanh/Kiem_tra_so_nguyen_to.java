package vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class Kiem_tra_so_nguyen_to {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("kiểm tra số nguyên tố ");
        System.out.println("nhập giá trị :");
        int so=sc.nextInt();
        int dem=0;
        if(so==2){
            System.out.println(so +" không phải là số nguyên tố");
        }else {
        for(int i=1;i<=so;i++){
            if(so%i==0) {
                dem++;
            }
        }
        if(dem==2){
            System.out.println(so +" là số nguyên tố");
        }else {
            System.out.println(so +" không phải là số nguyên tố");
        }
    }}

}

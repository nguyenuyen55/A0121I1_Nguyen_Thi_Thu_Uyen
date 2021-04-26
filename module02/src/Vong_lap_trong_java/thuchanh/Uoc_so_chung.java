package Vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class Uoc_so_chung {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("enter number first");
        int a=input.nextInt();
        System.out.println("enter number second");
        int b=input.nextInt();
        if(a==0||b==0){
            System.out.println("không có ước số chung");
        }
        while (a!=b){
            if(a>b){
                a=a-b;
            }else {
                b=b-a;
            }
        }
        System.out.println("ước số chung của hai số là "+a);
    }
}

package vong_lap_trong_java.baitap;

import java.util.Scanner;

public class Hien_thi_soNto_nho_100 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);


        String kq="";
        for (int i = 2; i < 100; i++) {
            int dem=0;
            if(i==2){
                dem=1;
            }else {
                for(int j=1;j<=i;j++){
                    if(i%j==0) {
                        dem++;
                    }
                }
                if(dem==2){

                    kq +=i+" ";
                }

            }
        }
        System.out.println(kq);
    }
    }


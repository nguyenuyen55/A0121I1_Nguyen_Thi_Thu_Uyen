package Vong_lap_trong_java.Baitap;

import java.util.Scanner;

public class Hien_thi_20_so_nto_dau_tien {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int demnto=0;
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
                    demnto++;
                    kq +=i+" ";
                }
                if(demnto==20) {
                    break;
                }
            }
        }
        System.out.println(kq);
    }
}

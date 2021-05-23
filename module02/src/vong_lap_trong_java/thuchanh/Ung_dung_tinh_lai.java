package vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class Ung_dung_tinh_lai {
    public static void main(String[] args) {
        int so_tien_gui=1;
        double lai_suat=1.0;
        int thang=0;
        Scanner input =new Scanner(System.in);
        System.out.println("nhập số tiền gửi ");
        so_tien_gui=input.nextInt();
        System.out.println("vay bao nhiêu tháng");
        thang=input.nextInt();
        System.out.println("nhập lãi xuất ");
        lai_suat=input.nextDouble();

        double tong_tien_tra=0;
        for (int i=0;i<thang;i++){
            tong_tien_tra += so_tien_gui*(lai_suat/100/12)*thang;
        }
        System.out.println("tông tiên " +tong_tien_tra);

    }
}

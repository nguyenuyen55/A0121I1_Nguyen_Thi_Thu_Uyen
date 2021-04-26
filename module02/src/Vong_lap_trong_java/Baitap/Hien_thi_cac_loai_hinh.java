package Vong_lap_trong_java.Baitap;

import java.util.Scanner;

public class Hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        //hien thi cac loai hinh
        Scanner input=new Scanner(System.in);
        int choice;
        do{
            System.out.println("======Menu=======");
            System.out.println("1. vẽ hình chữ nhật");
            System.out.println("2. vẽ hình tam giác vuông ");
            System.out.println("3. vẽ hình tam giác cân  ");
            System.out.println("4. Exit ");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println(" hình chữ nhật ");
                    for (int i = 0; i < 3; i++) {
                        for (int j=0;j<10;j++){
                            System.out.printf("*");
                        }
                        System.out.println("");
                    }


                    break;
                case 2:
                    System.out.println("hình tam giác vuông ");
                    for (int i = 0; i < 5; i++) {
                        for (int j=0;j<i;j++){
                            System.out.printf("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println(" hình tam giác cân ");
                    for (int i = 1; i <= 5; i++) {
                        for (int k=5;k>i;k--){
                            System.out.printf(" ");
                        }
                    for (int j=1;j<=i*2-1;j++){
                        System.out.printf("*");
                    }
                    System.out.println("");
                }break;
                default:
                    System.out.println("No choice!");
            }
        }while (choice<4 &&choice>0);


    }
}

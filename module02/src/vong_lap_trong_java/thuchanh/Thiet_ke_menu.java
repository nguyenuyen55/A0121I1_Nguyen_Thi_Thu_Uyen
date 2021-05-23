package vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class Thiet_ke_menu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;
        do{
            System.out.println("======Menu=======");
            System.out.println("1. vẽ hĩnh tam giác vuông");
            System.out.println("2. vẽ hĩnh chữ nhật ");
            System.out.println("3. vẽ hĩnh hình vuông ");
            System.out.println("4. Exit ");
           choice=input.nextInt();
           switch (choice){
               case 1:
                   System.out.println(" tam giác vuông");
                   System.out.println("*");
                   System.out.println("**");
                   System.out.println("***");
                   System.out.println("****");
                   System.out.println("******");
                   System.out.println("*******");
                   System.out.println("********");
                   System.out.println("*********");break;
               case 2:
                   System.out.println("hình chữ nhật ");
                   System.out.println("***************");
                   System.out.println("***************");
                   System.out.println("***************");break;
               case 3:
                   System.out.println(" hình vuông ");

                   System.out.println("*********");
                   System.out.println("*********");
                   System.out.println("*********");
                   System.out.println("*********");
                  break;
               default:
                   System.out.println("No choice!");
           }
        }while (choice<4 &&choice>0);

}}

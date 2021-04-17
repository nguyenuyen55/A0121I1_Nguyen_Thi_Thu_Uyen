package Introduction_to_java.baitap;

import java.util.Scanner;

public class Doc_so {
    public static  void dv(int so){
        switch (so){
            case 1:
                System.out.print("một"); break;
            case 2:
                System.out.print("hai"); break;
            case 3:
                System.out.print("ba"); break;
            case 4:
                System.out.print("bốn"); break;
            case 5:
                System.out.print("năm"); break;
            case 6:
                System.out.print("sáu"); break;
            case 7:
                System.out.print("bảy"); break;
            case 8:
                System.out.print("tám"); break;
            case 9:
                System.out.print("chín"); break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("So ban can doc: ");
        int number = scanner.nextInt();
        int t=(number/100);//sô trăm
        int c=(number%100)/10;//số hàng chục
        int dv=(number%100)%10;//số đơn vị
        if(number<10 && number >0){
            dv(dv);
       }else  if(number<100){
            switch (c){
                case 1:
                    System.out.print("mười"); break;
                case 2:
                    System.out.print("hai mươi "); break;
                case 3:
                    System.out.print("ba mươi "); break;
                case 4:
                    System.out.print("bốn mươi "); break;
                case 5:
                    System.out.print("năm mươi "); break;
                case 6:
                    System.out.print("sáu mươi "); break;
                case 7:
                    System.out.print("bảy mươi "); break;
                case 8:
                    System.out.print("tám mươi "); break;
                case 9:
                    System.out.print("chín mươi "); break;
            }
            dv(dv);
        }else if(number<1000){

            switch (t){
                case 1:
                    System.out.print("môt trăm "); break;
                case 2:
                    System.out.print("hai trăm "); break;
                case 3:
                    System.out.print("ba trăm "); break;
                case 4:
                    System.out.print("bốn trăm "); break;
                case 5:
                    System.out.print("năm trăm "); break;
                case 6:
                    System.out.print("sáu trăm "); break;
                case 7:
                    System.out.print("bảy trăm "); break;
                case 8:
                    System.out.print("tám trăm "); break;
                case 9:
                    System.out.print("chín trăm "); break;
            }
            switch (c){
                case 0:
                    System.out.print("lẻ ");break;
                case 1:
                    System.out.print("mười"); break;
                case 2:
                    System.out.print("hai mươi "); break;
                case 3:
                    System.out.print("ba mươi "); break;
                case 4:
                    System.out.print("bốn mươi "); break;
                case 5:
                    System.out.print("năm mươi "); break;
                case 6:
                    System.out.print("sáu mươi "); break;
                case 7:
                    System.out.print("bảy mươi "); break;
                case 8:
                    System.out.print("tám mươi "); break;
                case 9:
                    System.out.print("chín mươi "); break;
            }
            dv(dv);
        }else {
            System.out.println("chưa lập trình tới ><");
        }


    }
}

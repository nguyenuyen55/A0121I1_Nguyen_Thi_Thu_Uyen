package BaiTapLinhTinh;

import java.util.Scanner;

public class DemSoChanLe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
        int demC=0;
        int demL=0;
        for (double a :arr) {
            if(a%2==0){
                demC++;
            }else {
                demL++;
            }
        }
        System.out.println(demC);
        System.out.println(demL);
    }
}

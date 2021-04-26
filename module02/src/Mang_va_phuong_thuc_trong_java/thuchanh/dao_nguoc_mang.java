package Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class dao_nguoc_mang {
    public static void main(String[] args) {
        //mang dao ngược
        Scanner input =new Scanner(System.in);
        System.out.println("Enter a size :");
        int size=input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("enter element "+(i+1)+" :");
            array[i]=input.nextInt();
        }
        System.out.println("array before reverse :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        for (int j=0;j<array.length/2;j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println("\narray after reverse :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
}

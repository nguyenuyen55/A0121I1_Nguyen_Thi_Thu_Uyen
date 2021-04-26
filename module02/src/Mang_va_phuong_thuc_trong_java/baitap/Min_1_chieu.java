package Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Min_1_chieu {

    public static void nhap(int[] list, int sophantu) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < sophantu; i++) {
            System.out.println("enter element " + (i + 1) + " :");
            list[i] = input.nextInt();
        }
    }

    public static void xuat(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void min(int[] list) {
        int vtri = 1;
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
                vtri = i;
            }
        }
        System.out.println("\ngiá trị nhỏ nhất trong mảng là " + min + " ở vị trí " + vtri);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size:");
            size = input.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);

        int[] array = new int[size];
        nhap(array, size);
        xuat(array);
        min(array);


    }
}

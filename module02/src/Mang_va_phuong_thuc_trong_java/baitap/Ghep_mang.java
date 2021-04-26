package Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Ghep_mang {
    public static void nhap(int[] list, int sophantu) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < sophantu; i++) {
            System.out.printf("enter element " + (i + 1) + " :");
            list[i] = input.nextInt();
        }
    }

    public static void xuat(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void gop(int[] list, int[] list1) {
        int newArr[] = new int[list.length + list1.length];
        for (int i = 0; i < list.length; i++) {
            newArr[i] = list[i];
        }
        for (int i = 0; i < list1.length; i++) {
            newArr[i + list.length] = list1[i];

        }
        xuat(newArr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("mảng 1 có bao nhiêu phân tử : ");
        int size1 = scanner.nextInt();
        int mang[] = new int[size1];
        nhap(mang, size1);
        System.out.println("mảng 2 có bao nhiêu phân tử");
        int size2 = scanner.nextInt();
        int mang1[] = new int[size2];
        nhap(mang1, size2);
        System.out.println("mảng 1");
        xuat(mang);
        System.out.println("mảng 2");
        xuat(mang1);
        System.out.println("ghép hai mảng lại");
        gop(mang, mang1);

    }
}

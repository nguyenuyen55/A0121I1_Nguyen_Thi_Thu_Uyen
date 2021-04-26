package Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Them_phantu {

    public static void ThemPhantu(int[] list, int value, int index) {
        if (index < 1 && index > list.length - 1) {
            System.out.println("vị trí ko hợp lệ");
            return;
        } else {
            int[] list1 = new int[list.length + 1];


//            for (int i = list.length-1; i >index ; i--) {
//                list[i]=list[i-1];
//            }
//            list[index]=value;
            for (int i = 0; i < list1.length; i++) {
                if (i < index) {
                    list1[i] = list[i];
                } else if (i > index) {
                    list1[i] = list[i - 1];
                } else {
                    list1[index] = value;
                }
            }

            // for (int i = 0; i < list.length; i++) {
//                if ((i + 1) == index) {
//                    int temp = list[i];
//                    list1[i] = value;
//                    for (int j = i + 1; j <= list1.length; j++) {
//                        list1[j] = list[j - 1];
//                    }
//                } else {
//                    list1[i] = list[i];
//                }
            //}
            xuat(list1);

        }
    }

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

    public static void main(String[] args) {
//        chen phan tu
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size:");
            size = input.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        int[] array = new int[size + 1];
        nhap(array, size);
        xuat(array);
        System.out.println("\nnhập giá trị muốn chèn :");
        int value = input.nextInt();
        System.out.println("nhập vị trí cần muốn chèn :");
        int viTriChen = input.nextInt();
        ThemPhantu(array, value, viTriChen);
    }
}


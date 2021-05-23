package mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class Xoa_ptu_khoi_mang {
    public static void xoaPhantu(int[] list, int soCanXoa) {
        int sizze = list.length;

        int dem = 0;
        int k = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == soCanXoa) {
                dem++;
            }
        }
        int newArray[] = new int[sizze - dem];
        for (int i = 0; i < list.length; i++) {
            if (list[i] == soCanXoa) {
                continue;
            }
            newArray[k] = list[i];
            k++;
        }
        if (dem > 0) {
            xuat(newArray);
        } else {
            System.out.println("không tìm thấy giá trị cần xoá");
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
//        xoa phan tu trong mang
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
        System.out.println("\nnhập giá trị cần xoá :");
        int soCanXoa = input.nextInt();
        xoaPhantu(array, soCanXoa);

    }
}

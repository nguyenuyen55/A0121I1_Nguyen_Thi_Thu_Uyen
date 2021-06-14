package demo;

import java.util.Scanner;

public class Demo {
    public static int timKiem(int ptu, int[] array) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ptu) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr;
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số phân tử trong mảng ");
        int n = input.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] : ");
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("nhập phân tử cần tìm ");
        int phanTu = input.nextInt();
        System.out.println(timKiem(phanTu, arr));
    }
}

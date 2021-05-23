package mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class Tim_max_mang {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
    int size;
        do {
        System.out.print("Enter a size:");
        size = input.nextInt();
        if (size > 20)
            System.out.println("Size should not exceed 20");
    } while (size > 20);

    int[] array = new int[size];
        for (int i = 0; i < size; i++) {
        System.out.println("enter element "+(i+1)+" :");
        array[i]=input.nextInt();
    }
        for (int i = 0; i < array.length; i++) {
        System.out.print(array[i]+" ");
    }

    //khoi tao max
    int vt=1;
    int max= array[0];
        for (int i = 0; i <size ; i++) {
        if(array[i]>max){
            max=array[i];
            vt=i+1;
        }
    }
        System.out.println("\ngiá trị lớn nhất trong mảng là "+max+" ở vị trí "+vt);
}
}

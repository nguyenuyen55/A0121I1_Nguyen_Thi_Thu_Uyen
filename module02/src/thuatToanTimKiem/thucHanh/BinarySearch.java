package thuatToanTimKiem.thucHanh;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int[] list = {1, 2, 3, 5, 23, 52, 6, 7, 973, 23};

    static int binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;

        while (right >= left) {
            int middle = (right + left) / 2;
            if (list[middle] > key) {
                right = middle - 1;
            } else if (list[middle] < key) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Arrays.sort(list);
        for (Integer  i:
             list) {
            System.out.print(i+" ");
        }
        System.out.print("\nEnter value need find : ");
        int key =scanner.nextInt();
        if(binarySearch(list,key)>-1){
            System.out.println("value "+key+" in index "+binarySearch(list,key));
        }else {
            System.out.println("not find value");
        }
    }
}

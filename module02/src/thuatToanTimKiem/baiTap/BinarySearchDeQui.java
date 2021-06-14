package thuatToanTimKiem.baiTap;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDeQui {
    static int[] list={9,2,3,1,3,4,1,4,6,8,8,5,33,8};
    static int binarySearch(int left,int right,int[] list ,int value){
        int mid =(left+right)/2;
         if(left>right){
             return -1;
         }else {

             if(list[mid] >value){
                 return binarySearch(left,mid-1,list,value);
             }else if(list[mid]<value){
                 return binarySearch(mid+1,right,list,value);
             }else {
                 return mid;
             }
         }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Arrays.sort(list);
        for (Integer i:
             list) {
            System.out.print(i+" ");
        }
        System.out.println("\nnhập số cần tìm ");
        int key=scanner.nextInt();
        if(binarySearch(0,list.length-1,list,key)==-1){
            System.out.println("Không tìm thấy ");

        }else {
            System.out.println("nó nằm ở vị trí "+binarySearch(0,list.length-1,list,key));
        }
    }

}

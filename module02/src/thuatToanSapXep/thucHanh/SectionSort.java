package thuatToanSapXep.thucHanh;

public class SectionSort {
    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(i!=min){
                int temp=arr[i];
                arr[i] =arr[min];
                arr[min]=temp;
            }
        }
    }
    static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] list = {3, 5, 7, 2, 9, 2, 1, 0, 4, 2};
        display(list);
        System.out.println();
        selection(list);
        display(list);
    }
}

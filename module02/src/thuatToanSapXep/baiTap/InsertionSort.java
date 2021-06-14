package thuatToanSapXep.baiTap;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] list = {3, 5, 7, 2, 9, 2, 1, 0, 4, 2};
        display(list);
        System.out.println();
        insertionSort(list);
        display(list);
    }
}

package thuatToanSapXep.baiTap;

public class BubbleSort {
    static void bubbleSort(int[] array) {
        boolean needNextPass=true;
        for (int i = 1; i < array.length; i++) {
            needNextPass=false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    needNextPass=true;
                }
            }
        }
        if(!needNextPass){
            System.out.println("Array may be sorted and next pass not needed");
        }
    }

    static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] list = {3, 5, 7, 2, 9, 2, 1, 0, 4, 2};
        display(list);
        System.out.println();
        bubbleSort(list);
        display(list);
    }
}

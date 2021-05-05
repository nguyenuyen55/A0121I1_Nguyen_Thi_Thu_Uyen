package Lop_va_Doi_tuong_trong_java.baiTap;

import java.util.Arrays;

public class Demo_StopWatch {
    public static void main(String[] args) {

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100000);
        }
        StopWatch st = new StopWatch();
        Arrays.sort(arr);
        st.stop();
        System.out.println(st.getElapsedTime());

    }
}

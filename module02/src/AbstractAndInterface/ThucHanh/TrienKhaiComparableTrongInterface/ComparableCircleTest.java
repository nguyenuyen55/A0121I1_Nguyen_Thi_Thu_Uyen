package AbstractAndInterface.ThucHanh.TrienKhaiComparableTrongInterface;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles =new ComparableCircle[3];
        circles[0]=new ComparableCircle(3.6);
        circles[1]=new ComparableCircle();
        circles[2]=new ComparableCircle(3.5,"red");
        System.out.println("Pre-sorted: ");
        for (ComparableCircle circle: circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("array after sort");
        for (ComparableCircle circle: circles) {
            System.out.println(circle);
        }

    }
}

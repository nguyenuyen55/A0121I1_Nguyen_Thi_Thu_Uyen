package lesson10DsaDanhSach.baiTap.linkedList;

public class Test {
    static int USCLN(double a, double b) {
        double temp1 = a;
        double temp2 = b;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        double uscln = temp1;
        return (int) uscln;
    }

    public static void main(String[] args) {
        System.out.println(USCLN(3, 9.2));

    }
}

package exceptionAndDebug.baiTap;

import java.util.Scanner;

public class DemoillegalTringleException {
    public static void main(String[] args) throws IllegalTringleException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter b :");
        int b = sc.nextInt();
        System.out.println("Enter c  :");
        int c = sc.nextInt();
        if (a < 0 || b < 0 || c < 0 || a + b < c || b + c < a || c + a < b) {
            throw new IllegalTringleException();
        }

    }
}


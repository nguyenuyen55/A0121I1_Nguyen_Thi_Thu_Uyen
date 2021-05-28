package stackAndQueue.baiTap;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocSoStack {
    public static void main(String[] args) {
        //dao nguoi so
        Scanner sc= new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        System.out.println("Nhap so phan tu trong mang ");
        int soPhanTu= sc.nextInt();
        int[] array =new int[soPhanTu];
        for (int i = 0; i < soPhanTu; i++) {
            System.out.println("nhap a["+i+"]");
            array[i]=sc.nextInt();
            stack.push(array[i]);
        }
        System.out.println("dãy sô sau khi đảo ngược ");
        while (!stack.isEmpty()){
            System.out.printf(stack.pop()+" ");
        }
        sc.nextLine();
        Stack<Character> stackString=new Stack<>();
        System.out.println("nhập chuỗi cần dảo ngược ");
        String chuoi =sc.nextLine();
        for (int i = 0; i < chuoi.length(); i++) {
            stackString.push(chuoi.charAt(i));
        }
        System.out.println("chuoi khi đảo ngược ");
        while (!stackString.isEmpty()){
            System.out.print(stackString.pop());
        }
    }
}

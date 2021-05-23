package mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class Tìm_gia_tri {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        //cho mot danh sach ten sinh vien rồi nhập tên muốn tìm
        String student[] ={"uyen","tam","nhu","phat"};
        System.out.println("nhập tên sinh viên ");
        String inputname=input.nextLine();
        boolean Isexit=false;
        for (int i = 0; i <student.length ; i++) {
            if(student[i].equals(inputname)){
                System.out.println("tên "+inputname+" ở vị trí "+(i+1));
                Isexit=true;
                break;
            }
        }
        if(!Isexit){
            System.out.println("không tìm thấy tên này trong danh sách");
        }
    }
}

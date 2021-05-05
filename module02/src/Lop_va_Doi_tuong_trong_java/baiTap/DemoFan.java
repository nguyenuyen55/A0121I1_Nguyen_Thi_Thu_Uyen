package Lop_va_Doi_tuong_trong_java.baiTap;

import com.sun.org.apache.bcel.internal.generic.FADD;

public class DemoFan {
    public static void main(String[] args) {
        Fan fan=new Fan(Fan.MEDIUM,true,5,"pink");
        Fan fan1=new Fan(Fan.SLOW,false,5,"blue");
        System.out.println(fan.toString());
        System.out.println(fan1.toString());
    }
}

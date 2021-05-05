package phan5.ThucHanh.StaticMethod;

public class Student {
    private String name;
    private int age;
    private static String tenTruong="SPKT DA NANG";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //Phuong thuc thay doi gia tri static
    static void chage(){
        tenTruong="CodeGym";
    }
    void display(){
        System.out.println("ten : "+ name+", tuoi : "+age+", học tại : "+tenTruong );
    }
}

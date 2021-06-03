package javaCollectionFramework.thucHanh.comparableAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DemoCompara {
    public static void main(String[] args) {
        ArrayList<Student> students =new ArrayList<>();
        students.add(new Student("Uyen",21,"NewYork"));
        students.add(new Student("Nga",19,"Thanh Hoa"));
        students.add(new Student("Tram",20,"Da Nang"));
        students.add(new Student("Loan",21,"Binh Dinh"));
        students.add(new Student("Thuan",21,"Quang Ngai"));
        for (Student student: students ) {
            System.out.print(student.getName()+" ");
        }
        System.out.println();
        Collections.sort(students);
        for (Student student: students ) {
            System.out.print(student.getName()+" ");
        }
        //sort Age
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(students,ageComparator);
        System.out.println("So sánh theo tuổi : ");
        for (Student student: students ) {
            System.out.println(student.toString());
        }
    }
}

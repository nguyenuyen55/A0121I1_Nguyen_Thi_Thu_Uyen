package javaCollectionFramework.thucHanh.hashMapAndHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DemoHashMapAndHashSet {
    public static void main(String[] args) {
        Student student1 =new Student("Uyen",21,"NewYork");
        Student student2 =new Student("Nga",20,"Thanh Hoa");
        Student student3 =new Student("Tram",19,"Da Nang");
        Student student4 =new Student("Loan",16,"Binh Dinh");
        Student student5 =new Student("Thuan",21,"Quang Ngai");
        HashMap<Integer,Student> studentHashMap = new HashMap<>();
        studentHashMap.put(9,student1);
        studentHashMap.put(3,student2);
        studentHashMap.put(2,student3);
        studentHashMap.put(4,student4);
        studentHashMap.put(5,student5);
        System.out.println("Print list of hash map");
        for(Map.Entry<Integer,Student> e : studentHashMap.entrySet()){
            System.out.println(e.toString());
        }
        ///examples
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(student1);
        studentHashSet.add(student2);
        studentHashSet.add(student3);
        studentHashSet.add(student4);
        studentHashSet.add(student1);
        studentHashSet.add(student2);
        //print list of has set
        for(Student student :studentHashSet){
            System.out.println(student.getName());
        }
///test : Do haspMap have order sort ?
        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("John", 30);
        customers.put("Mike", 28);
        customers.put("Bill", 32);
        customers.put("Maria", 27);

        Set<String> keys = customers.keySet();
        for (String key: keys){
            System.out.println("Key: " + key + ": " + customers.get(key));
        }
    }
}

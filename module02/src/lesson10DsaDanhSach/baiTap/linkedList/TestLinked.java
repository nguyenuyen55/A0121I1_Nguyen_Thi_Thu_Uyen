package lesson10DsaDanhSach.baiTap.linkedList;

public class TestLinked {
    public static void main(String[] args) {
        MyLinkedList<Student> studentMyLinkedList = new MyLinkedList<>();
        Student a = new Student("uyen", 21);
        Student b = new Student("tam", 18);
        Student c = new Student("nhu", 1);
        Student d = new Student("phat", 14);
        Student e = new Student("dai", 28);

        studentMyLinkedList.addFirst(a);
        studentMyLinkedList.addFirst(b);


        studentMyLinkedList.remove(a);
        studentMyLinkedList.clear();
        System.out.println(studentMyLinkedList.indexOf(a));
        for (int i = 0; i < studentMyLinkedList.size(); i++) {
            System.out.println(studentMyLinkedList.get(i).toString());
        }
    }
}

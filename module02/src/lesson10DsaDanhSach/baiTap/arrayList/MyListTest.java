package lesson10DsaDanhSach.baiTap.arrayList;


public class MyListTest {
public static class Student{
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



    public static void main(String[] args) {
        MyList<Integer> myList =new MyList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(4);
        myList.add(9);
        myList.add(12);
        myList.add(8);
    //  myList.remove(2);
        System.out.println(myList.indexOf(4));
        System.out.println(myList.contains(5));
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.elements[i]);
        }
        MyList<Student> myListObject =new MyList<>();
        myListObject.add(new Student(1,"phung"));
        myListObject.add(new Student(2,"Loan"));
        myListObject.add(new Student(3,"thuan"));
        myListObject.add(new Student(4,"hien"));
        myListObject.add(new Student(5,"tram"));
        myListObject.add(new Student(6,"nga"));
        myListObject.add(new Student(6,"Đạt"),3);

myListObject.clear();

        for (int i = 0; i < myListObject.size(); i++) {
            Student student= (Student) myListObject.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }

    }
}

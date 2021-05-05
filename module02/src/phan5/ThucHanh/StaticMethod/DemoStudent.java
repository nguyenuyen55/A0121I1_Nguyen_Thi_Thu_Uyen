package phan5.ThucHanh.StaticMethod;

public class DemoStudent {
    public static void main(String[] args) {
        Student st=new Student("uyen",21);
        Student st1=new Student("tamm",18);
        Student st2=new Student("phat",5);
        Student.chage();
        st.display();
        st1.display();
        st2.display();

    }
}

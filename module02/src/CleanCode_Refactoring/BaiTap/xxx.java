package CleanCode_Refactoring.BaiTap;

public class xxx {
    public static void main(String[] args) {
        Test test=new Test() {


            @Override
            public void jiji() {

            }

            @Override
            public void helo() {
                System.out.println("hello");
            }
        };
        test.helo();
    }
}

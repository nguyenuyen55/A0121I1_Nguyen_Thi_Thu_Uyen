package cleanCode_Refactoring.baiTap;

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

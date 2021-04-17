package Introduction_to_java.thuchanh;

import java.util.Scanner;

public class Can_nang_co_the {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhâp chiều cao của bạn");
        double height=sc.nextDouble();
        System.out.println("nhâp cân nặng của bạn");
        double weight=sc.nextDouble();
        double bmi=weight/Math.pow(height,2);
        if(bmi<18.5){
            System.out.println("chỉ số bmi cảu bạn là Underweight");
        }else if(bmi<25){
            System.out.println("chỉ số bmi cảu bạn là Normal");
        }
        else if(bmi<30){
            System.out.println("chỉ số bmi cảu bạn là Overweight");
        }else {
            System.out.println("chỉ số bmi cảu bạn là Obese");
        }
    }
}

package stringAndRegex.thuchanh;


public class DemoValidateEmail {
public static String[] validEmail=new String[] {"a@gmail.com","ab@yahoo.com","abc@hotmail.com"};
public static String[] invalidEmail = new String[] {"@gmail,com","ab@gmail.","@#abc@gmail.com"};

    public static void main(String[] args) {
        ValidateEmail validateEmail =new ValidateEmail();
        for (String str : validEmail){
            boolean isvalidate = validateEmail.validate(str);
            System.out.println("Email is "+str+" is validate "+isvalidate);
        }
        for (String str : invalidEmail){
            boolean isvalidate = validateEmail.validate(str);
            System.out.println("Email is "+str+" is validate "+isvalidate);
        }
    }

}


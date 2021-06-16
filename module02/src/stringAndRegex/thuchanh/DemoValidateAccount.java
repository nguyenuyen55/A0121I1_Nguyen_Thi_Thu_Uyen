package stringAndRegex.thuchanh;
/*
* hop le
* 123abc_
* _abc123
* ______
* 123456
* abcdef
* khong hop le
* .@
* 12345
* 1234_
* abcde
*
* */
public class DemoValidateAccount {
    static String[] validateAccount ={"123abc_","_abc123","______","123456"};
    static String[] invalidate ={".@","12345","1234_","abcde"};

    public static void main(String[] args) {
        ValidateAccount validaAccount =new ValidateAccount();
       for (String str : validateAccount){
            boolean vali = validaAccount.CheckValidate(str);
           System.out.println("Account :"+str + " is validate "+vali);
        }
        for (String str : invalidate){
            boolean vali = validaAccount.CheckValidate(str);
            System.out.println("Account :"+str + " is validate "+vali);
        }
    }
}

package stringAndRegex.baiTap;

public class DemoValiPhone {
    static String[] valiOrInvali = {"(84)-(0978489648)", "(84)-(0178489648)", "(u4)-(0978489648)"};

    public static void main(String[] args) {
        ValidatePhone validateAccount = new ValidatePhone();
        for (String str : valiOrInvali) {
            boolean valiorinvali = validateAccount.CheckRegex(str);
            System.out.println(str + " is validate " + valiorinvali);
        }

    }
}

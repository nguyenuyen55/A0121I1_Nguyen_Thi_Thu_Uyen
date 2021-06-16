package stringAndRegex.baiTap;

import stringAndRegex.thuchanh.ValidateAccount;

public class DemoValiClass {
    static String[] valiOrInvali={"C0318G","M0118G","P0234A"};
    public static void main(String[] args) {
        ValidateClass validateAccount =new ValidateClass();
      for (String str: valiOrInvali){
          boolean valiorinvali =validateAccount.CheckRegex(str);
          System.out.println(str+" is validate "+valiorinvali);
      }

    }
}

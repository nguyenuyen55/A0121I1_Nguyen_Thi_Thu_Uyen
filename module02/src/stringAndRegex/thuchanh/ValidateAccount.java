package stringAndRegex.thuchanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static Pattern pattern;
    private static Matcher matcher;
    private static String regex="^[_a-z0-9]{6,}$";
    public ValidateAccount(){
        pattern=Pattern.compile(regex);
    }
    public boolean CheckValidate(String regex){
        matcher =pattern.matcher(regex);
        return matcher.matches();
    }
}

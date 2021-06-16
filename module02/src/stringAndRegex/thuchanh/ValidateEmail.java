package stringAndRegex.thuchanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Matcher matcher;

    public ValidateEmail() {
        pattern =Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(String regex){
        matcher =pattern.matcher(regex);
        return matcher.matches();
    }

}

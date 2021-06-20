package stringAndRegex.baiTap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone  {
static final String regex="^[(][0-9]{2}[)][-][(][0][1-9]{9}[)]$";
public ValidatePhone(){

}
    public boolean CheckRegex(String strRegex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(strRegex);
        return matcher.matches();
    }

}

package common;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final   String regexCustomer ="^KH-[0-9]{4}$";
    private static final   String regexService ="^DV-[0-9]{4}$";
    private static final   String regexcmnd ="^[0-9]{9}?$|^[0-9]{12}$";


    public Validation(){

    }
    public boolean CheckRegexCus(String strRegex){
        Pattern pattern = Pattern.compile(regexCustomer);
        Matcher matcher =pattern.matcher(strRegex);
        return matcher.matches();
    }
    public boolean CheckRegexSer(String strRegex){
       Pattern pattern= Pattern.compile(regexService);
       Matcher matcher = pattern.matcher(strRegex);
       return matcher.matches();
    }
    public boolean CheckRegexCmnd(String strRegex){
        Pattern pattern= Pattern.compile(regexcmnd);
        Matcher matcher = pattern.matcher(strRegex);
        return matcher.matches();
    }
    public boolean CheckRegexSoDuong(double strRegex){
        if(strRegex>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean CheckDate(Date date){
        return true;
    }

    public static void main(String[] args) {
        Validation validation = new Validation();
    }
}

package util;

import java.util.regex.Pattern;

public class RegexUtil {
    public boolean configString(String regex,String obj){
        boolean b = Pattern.matches(regex, obj);
        return b;
    }
   

}

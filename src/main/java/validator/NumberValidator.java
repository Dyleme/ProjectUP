package validator;

import java.util.regex.Pattern;

public class NumberValidator{
    private static final String pattern = "^([1-9][0-9]*)(/[1-9])?[A-Z]*";

    public static boolean isValid(String string){
        return Pattern.matches(pattern, string);
    }
}

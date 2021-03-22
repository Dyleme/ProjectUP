package validator;

import java.util.regex.Pattern;

public class CapitalLetterValidator {
    private static final String pattern = "^[A-Z]";

    public static boolean isValid(String string){
        return Pattern.matches(pattern, string);
    }
}

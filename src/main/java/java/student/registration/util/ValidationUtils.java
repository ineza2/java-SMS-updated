package java.student.registration.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private static final String MOBILE_REGEX = "^[0-9]{10}$";

    public static boolean isValidMobile(String mobile) {
        Pattern pattern = Pattern.compile(MOBILE_REGEX);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,20}$";

    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

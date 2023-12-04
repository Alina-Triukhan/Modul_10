import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Регулярний вираз для перевірки формату телефонного номеру
        String phoneRegex = "^\\((\\d{3})\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}


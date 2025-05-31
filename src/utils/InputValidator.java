package utils;

public class InputValidator {

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^\\S+@\\S+\\.\\S+$");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isNonEmptyString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPositiveNumber(String value) {
        try {
            return Double.parseDouble(value) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }
}

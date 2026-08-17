package library.util;
public class InputValidator {
    public static boolean validateResourceId(int id) {
        if (id > 0) {
            return true;
        }
        return false;
    }
    public static boolean validateFineDays(int days) {
        if (days >= 0) {
            return true;
        }
        return false;
    }
}

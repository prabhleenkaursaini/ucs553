import java.util.Objects;
import java.util.Optional;
class GenericUtility {
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }
    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }
    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}
public class Q5 {
    public static void main(String[] args) {
        System.out.println("isEqual with integers (10, 10): " + GenericUtility.isEqual(10, 10));
        System.out.println("isEqual with integers (10, 20): " + GenericUtility.isEqual(10, 20));
        System.out.println("isEqual with strings (\"java\", \"java\"): " + GenericUtility.isEqual("java", "java"));
        System.out.println("isEqual with strings (\"java\", \"c++\"): " + GenericUtility.isEqual("java", "c++"));
        Optional<String> strOpt1 = Optional.of("Hello");
        Optional<String> strOpt2 = Optional.empty();
        System.out.println("getDefault with present value: " + GenericUtility.getDefault(strOpt1, "DefaultString"));
        System.out.println("getDefault with empty optional: " + GenericUtility.getDefault(strOpt2, "DefaultString"));
        Optional<Integer> intOpt = Optional.empty();
        System.out.println("getDefault with empty integer optional: " + GenericUtility.getDefault(intOpt, 100));
        System.out.println("max with integers (15, 25): " + GenericUtility.max(15, 25));
        System.out.println("max with strings (\"Apple\", \"Banana\"): " + GenericUtility.max("Apple", "Banana"));
        System.out.println("max with doubles (4.5, 3.2): " + GenericUtility.max(4.5, 3.2));
        String nullStr = null;
        String validStr = "Hello";
        Integer num = 50;
        System.out.println("isNull on null object: " + GenericUtility.isNull(nullStr));
        System.out.println("isNull on valid string: " + GenericUtility.isNull(validStr));
        System.out.println("isNull on valid integer: " + GenericUtility.isNull(num));
    }
}
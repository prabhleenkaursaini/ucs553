public class Q1 {
    public static <T extends Number> double calculateSum(T[] numbers) {
        double sum = 0.0;
        for (T num : numbers) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }
    public static void main(String[] args) {
        Integer[] intArr = {10, 20, 30, 40};
        Float[] floatArr = {1.5f, 2.5f, 3.5f};
        Double[] doubleArr = {10.2, 20.3, 30.5};
        System.out.println("Sum of integers: " + calculateSum(intArr));
        System.out.println("Sum of floats: " + calculateSum(floatArr));
        System.out.println("Sum of doubles: " + calculateSum(doubleArr));
    }
}
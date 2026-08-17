package food.utility;
public class OrderUtility {
    public static boolean validateAmount(double amount) {
        if (amount > 0) {
            return true;
        }
        return false;
    }
    public static boolean validateCustomerName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public static void generateOrderSummary(int orderId, String customerName, double amount, double discount, double deliveryCharge) {
        double finalAmount = amount - discount + deliveryCharge;
        System.out.println("--------------------------------------------------");
        System.out.println("Order ID       : " + orderId);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Bill Amount    : Rs. " + amount);
        System.out.println("Discount       : Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + deliveryCharge);
        System.out.println("Final Payable  : Rs. " + finalAmount);
        System.out.println("--------------------------------------------------");
    }
}

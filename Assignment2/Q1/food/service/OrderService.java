package food.service;
import food.model.FoodOrder;
import food.model.Discountable;
import food.utility.OrderUtility;
public class OrderService {
    public void processOrder(FoodOrder order) {
        if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
            System.out.println("Invalid customer name for order " + order.getOrderId());
            return;
        }
        if (!OrderUtility.validateAmount(order.getAmount())) {
            System.out.println("Invalid amount for order " + order.getOrderId());
            return;
        }
        double discount = 0;
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }
        double deliveryCharge = order.calculateDeliveryCharge();
        OrderUtility.generateOrderSummary(order.getOrderId(), order.getCustomerName(), order.getAmount(), discount, deliveryCharge);
    }
}

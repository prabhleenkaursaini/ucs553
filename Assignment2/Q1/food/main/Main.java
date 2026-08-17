package food.main;
import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.model.Discountable;
import food.service.OrderService;
public class Main {
    public static void main(String[] args) {
        FoodOrder[] orders = new FoodOrder[6];
        orders[0] = new RegularOrder(101, "Rahul Sharma", 350);
        orders[1] = new RegularOrder(102, "Neha Gupta", 500);
        orders[2] = new RegularOrder(103, "Amit Verma", 200);
        orders[3] = new PremiumOrder(104, "Priya Singh", 800);
        orders[4] = new PremiumOrder(105, "Karan Mehta", 1200);
        orders[5] = new PremiumOrder(106, "Sneha Patel", 650);
        System.out.println("Restaurant: " + FoodOrder.restaurantName);
        System.out.println();
        OrderService service = new OrderService();
        for (int i = 0; i < orders.length; i++) {
            service.processOrder(orders[i]);
        }
        System.out.println();
        FoodOrder.displayTotalOrders();
    }
}

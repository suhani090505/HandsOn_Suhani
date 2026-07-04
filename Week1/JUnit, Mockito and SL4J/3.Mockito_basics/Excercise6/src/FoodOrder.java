public class FoodOrder {

    private DeliveryService service;

    public FoodOrder(DeliveryService service) {
        this.service = service;
    }

    public void placeOrder() {

        service.checkRestaurant();

        service.processPayment();
    }
}
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class FoodOrderTest {

    @Test
    public void testOrder() {

        DeliveryService mockService =
                Mockito.mock(DeliveryService.class);

        FoodOrder order = new FoodOrder(mockService);

        order.placeOrder();

        InOrder inOrder = Mockito.inOrder(mockService);

        inOrder.verify(mockService).checkRestaurant();
        inOrder.verify(mockService).processPayment();
    }
}
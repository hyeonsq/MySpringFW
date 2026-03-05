package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@ContextConfiguration(locations="classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    ShoppingCart cart;

    @Autowired
    OrderService service;

    @Test
    public void testShoppingCart() {
        assertNotNull(cart);

        assertEquals(2, cart.getProducts().size());
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
    }

    @Test
    public void testOrderService() {
        assertNotNull(service);

        double total = service.calculateOrderTotal();
        
        System.out.println("총 주문 금액 : " + total);
        
        assertEquals(950000, total);
    }
}
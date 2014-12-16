package item;

import habens.item.DiscountItem;
import habens.item.Item;
import habens.item.NormalItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountItemTest {

    @Test
    public void should_get_discounted_cost_when_checkout_discount_item() throws Exception{
        Item item = new NormalItem("ITEM01", 100);
        item = new DiscountItem(item, 90);

        float cost = item.cost();

        assertEquals(cost, 100*90/100, 0.001);
    }

}
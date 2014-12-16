package item;

import habens.item.Item;
import habens.item.NormalItem;
import habens.item.SecondHalfPriceItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondHalfPriceItemTest{

    @Test
    public void should_get_promoted_cost_when_second_half_price() throws Exception {
        Item item = new NormalItem("ITEM01", 100);
        item = new SecondHalfPriceItem(item);
        int number = 2;

        float cost = item.cost(number);

        assertEquals(cost, 100+100/2, 0.001);
    }
}
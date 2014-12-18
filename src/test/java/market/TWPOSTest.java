package market;

import habens.Calculator.ReduceCostCalculator;
import habens.item.Item;
import habens.item.NormalItem;
import habens.market.TWPOS;
import habens.util.Order;
import habens.util.Result;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

public class TWPOSTest {

    @Test
    public void should_contains_the_item_when_create_from_list_contains_item() throws Exception {
        LinkedList<Item> itemLinkedList = new LinkedList<Item>();
        itemLinkedList.add(new NormalItem("ITEM01", 100));
        ReduceCostCalculator reduceCostCalculator = new ReduceCostCalculator();

        TWPOS twpos = new TWPOS(itemLinkedList, reduceCostCalculator);

        assertEquals("ITEM01", twpos.getItemList().get(0).getID());
        assertEquals(100, twpos.getItemList().get(0).getPrice(), 0.01);
    }

    @Test
    public void should_get_right_cost_when_checkout() throws Exception {
        List<Item> itemList = new LinkedList<Item>();
        ReduceCostCalculator reduceCostCalculator = new ReduceCostCalculator();
        itemList.add(new NormalItem("ITEM000001", 10));
        TWPOS twpos = new TWPOS(itemList, reduceCostCalculator);

        List<Order> orderList = new LinkedList<Order>();
        orderList.add(new Order("ITEM000001", 1));

        Result result = twpos.checkout(orderList);

        assertEquals(result.getTotal(), 10*1, 0.01);
    }
}
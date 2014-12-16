package market;

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

        TWPOS twpos = new TWPOS(itemLinkedList);

        assertEquals("ITEM01", twpos.getItemList().get(0).getID());
        assertEquals(100, twpos.getItemList().get(0).getPrice(), 0.01);
    }

    @Test
    public void should_get_right_cost_when_checkout() throws Exception {
        TWPOS twpos = new TWPOS();
        List<Item> itemList = new LinkedList<Item>();
        itemList.add( new NormalItem("ITEM000001", 10));
        twpos.setItemList(itemList);
        List<Order> orderList = new LinkedList<Order>();
        orderList.add(new Order("ITEM000001", 1));

        Result result = twpos.checkout(orderList);

        assertEquals(result.getTotal(), 10*1, 0.01);
    }
}
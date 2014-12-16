package market;

import habens.item.Item;
import habens.item.NormalItem;
import habens.market.TWMarket;
import habens.util.Stock;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TWMarketTest {

    @Test
    public void should_can_get_right_item_when_market_that_contains_the_item_created_successful() throws Exception {
        List<Stock> stockList = new LinkedList<Stock>();
        stockList.add(new Stock(new NormalItem("ITEM01", 100), 100)); // id, price, number

        TWMarket twMarket = new TWMarket();
        twMarket.setStockList(stockList);
        List<Item> itemList = twMarket.getItemList();

        assertEquals(itemList.get(0).getID(), "ITEM01");
        assertEquals(itemList.get(0).getPrice(), 100, 0.01);
    }
}
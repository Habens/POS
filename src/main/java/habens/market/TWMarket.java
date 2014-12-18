package habens.market;

import habens.item.Item;
import habens.promotion.Promotion;
import habens.util.Stock;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class TWMarket {
    private List<Stock> stockList;

    public TWMarket(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public void addPromotion(Promotion promotion) {
        if (promotion != null) {
            updateStockList(promotion);
        }
    }

    public List<Item> getItemList() {
        List<Item> itemList = new LinkedList<Item>();
        for (int i = stockList.size() - 1; i >= 0; i--) {
            itemList.add(stockList.get(i).getItem());
        }
        return itemList;
    }

    private void updateStockList(Promotion promotion) {
        List<String> itemIDList = promotion.getItemIDList();
        for (int i = itemIDList.size() - 1; i >= 0; i--) {
            String itemID = itemIDList.get(i);
            for (Stock stock : stockList) {
                Item item = stock.getItem();
                if (itemID.equals(item.getID())) {
                    item = promotion.update(item);
                    stock.setItem(item);
                }
            }
        }
    }

    public void show() {
        for (Stock stock : stockList) {
            System.out.println(stock.getItem().getID() + ":" +
                    stock.getItem().getPrice() + ":" +
                    stock.getNumber());
        }
    }
}

package habens.market;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import habens.item.Item;
import habens.parser.Parser;
import habens.promotion.Promotion;
import habens.util.Stock;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class TWMarket {
    private List<Stock> stockList;
    private Parser parser;

    @Inject
    public TWMarket(@Named("stock") List<Stock> stockList,
                    @Named("stock") Parser parser) {
        this.stockList = stockList;
        this.parser = parser;
    }

    public void initFromFile(String filePath) {
        this.stockList = parser.parseFromFile(filePath);
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

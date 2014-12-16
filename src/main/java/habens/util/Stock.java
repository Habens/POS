package habens.util;

import habens.item.Item;

/**
 * Created by habens on 11/21/14.
 */
public class Stock {
    private Item item;
    private int number;

    public Stock(Item item, int number) {
        this.item = item;
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getNumber() {
        return number;
    }
}

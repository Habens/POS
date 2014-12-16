package habens.promotion;

import habens.item.Item;
import habens.item.SecondHalfPriceItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class SecondHalfPricePromotion implements Promotion {
    private List<String> secondHalfPriceIDList;

    public SecondHalfPricePromotion() {
        secondHalfPriceIDList = new LinkedList<String>();
    }

    public SecondHalfPricePromotion(List<String> secondHalfPriceIDList) {
        this.secondHalfPriceIDList = secondHalfPriceIDList;
    }

    public List<String> getItemIDList() {
        return secondHalfPriceIDList;
    }

    public SecondHalfPriceItem update(Item item) {
        return new SecondHalfPriceItem(item);
    }

    public void show() {
        for (String ID : secondHalfPriceIDList) {
            System.out.println(ID);
        }
    }
}

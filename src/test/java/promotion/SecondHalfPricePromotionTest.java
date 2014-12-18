package promotion;

import habens.item.NormalItem;
import habens.item.SecondHalfPriceItem;
import habens.promotion.SecondHalfPricePromotion;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class SecondHalfPricePromotionTest {
    @Test
    public void should_get_second_half_price_item_when_item_was_updated() throws Exception {
        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(new LinkedList<String>());
        NormalItem normalItem = new NormalItem("ITEM01", 100);
        SecondHalfPriceItem secondHalfPriceItem = new SecondHalfPriceItem(normalItem);

        assertEquals(secondHalfPricePromotion.update(normalItem).getClass(),
                secondHalfPriceItem.getClass());
        assertEquals(secondHalfPricePromotion.update(normalItem).cost(2), 100 + 100 / 2, 0.01);
    }
}
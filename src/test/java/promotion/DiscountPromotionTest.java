package promotion;

import habens.item.DiscountItem;
import habens.item.NormalItem;
import habens.promotion.DiscountPromotion;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountPromotionTest {

    @Test
    public void should_get_discount_item_when_item_was_updated() throws Exception {
        DiscountPromotion discountPromotion = new DiscountPromotion();
        NormalItem normalItem = new NormalItem("ITEM01", 100);
        DiscountItem discountItem = new DiscountItem(normalItem, 90);

        assertEquals(discountPromotion.update(normalItem, 90).getClass(),
                discountItem.getClass());
        assertEquals(discountPromotion.update(normalItem, 90).cost(2), (100*90/100)*2, 0.01);
    }
}
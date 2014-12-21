package promotion;

import com.google.inject.Guice;
import com.google.inject.Injector;
import habens.injector.MyModule;
import habens.item.DiscountItem;
import habens.item.NormalItem;
import habens.promotion.DiscountPromotion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountPromotionTest {

    @Test
    public void should_get_discount_item_when_item_was_updated() throws Exception {
        Injector injector = Guice.createInjector(new MyModule());
        DiscountPromotion discountPromotion = injector.getInstance(DiscountPromotion.class);
        NormalItem normalItem = new NormalItem("ITEM01", 100);
        DiscountItem discountItem = new DiscountItem(normalItem, 90);

        assertEquals(discountPromotion.update(normalItem, 90).getClass(),
                discountItem.getClass());
        assertEquals(discountPromotion.update(normalItem, 90).cost(2), (100 * 90 / 100) * 2, 0.01);
    }
}
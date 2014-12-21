package promotion;

import com.google.inject.Guice;
import com.google.inject.Injector;
import habens.injector.MyModule;
import habens.item.NormalItem;
import habens.item.SecondHalfPriceItem;
import habens.promotion.SecondHalfPricePromotion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondHalfPricePromotionTest {
    @Test
    public void should_get_second_half_price_item_when_item_was_updated() throws Exception {
        Injector injector = Guice.createInjector(new MyModule());
        SecondHalfPricePromotion secondHalfPricePromotion = injector.getInstance(SecondHalfPricePromotion.class);
        NormalItem normalItem = new NormalItem("ITEM01", 100);
        SecondHalfPriceItem secondHalfPriceItem = new SecondHalfPriceItem(normalItem);

        assertEquals(secondHalfPricePromotion.update(normalItem).getClass(),
                secondHalfPriceItem.getClass());
        assertEquals(secondHalfPricePromotion.update(normalItem).cost(2), 100 + 100 / 2, 0.01);
    }
}
package habens.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import habens.Calculator.ReduceCostCalculator;
import habens.injector.MyModule;
import habens.market.TWMarket;
import habens.market.TWPOS;
import habens.parser.Parser;
import habens.promotion.DiscountPromotion;
import habens.promotion.SecondHalfPricePromotion;
import habens.util.*;
import habens.parser.ParserImpl.CartParser;
import habens.parser.ParserImpl.SecondHalfPriceParser;
import habens.parser.ParserImpl.StockParser;

import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class Shopping {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());

        Parser parser;

        TWMarket twMarket = injector.getInstance(TWMarket.class);
        twMarket.initFromFile("./src/main/resources/item_list.txt");
        DiscountPromotion discountPromotion = injector.getInstance(DiscountPromotion.class);
        discountPromotion.initFromFile("./src/main/resources/discount_promotion.txt");

        SecondHalfPricePromotion secondHalfPricePromotion = injector.getInstance(SecondHalfPricePromotion.class);
        secondHalfPricePromotion.initFromFile("./src/main/resources/second_half_price_promotion.txt");

        twMarket.addPromotion(discountPromotion);
        twMarket.addPromotion(secondHalfPricePromotion);

        Cart cart = injector.getInstance(Cart.class);
        cart.initFromFile("./src/main/resources/cart.txt");

        TWPOS twPOS = injector.getInstance(TWPOS.class);
        twPOS.setItemList(twMarket.getItemList());

        twPOS.checkout(cart.getOrderList()).show();
    }
}

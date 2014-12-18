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
import habens.parser.ParserImpl.CarParser;
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

        System.out.println("\n------------------\nMarket");
        parser = new StockParser();
        List<Stock> stockList = parser.parseFromFile("./src/main/resources/item_list.txt");
        TWMarket twMarket = new TWMarket(stockList);
        twMarket.show();

        DiscountPromotion discountPromotion = injector.getInstance(DiscountPromotion.class);
        discountPromotion.initFormFile("./src/main/resources/discount_promotion.txt");

        System.out.println("\n------------------\nDiscount Promotion");
        discountPromotion.show();

        parser = new SecondHalfPriceParser();
        List<String> secondHalfPriceIDList = parser.parseFromFile("./src/main/resources/second_half_price_promotion.txt");
        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(secondHalfPriceIDList);

        System.out.println("\n------------------\nSecondHalf Price Promotion");
        secondHalfPricePromotion.show();

        twMarket.addPromotion(discountPromotion);
        twMarket.addPromotion(secondHalfPricePromotion);

        parser = new CarParser();
        List<Order> orderList = parser.parseFromFile("./src/main/resources/cart.txt");
        Cart cart = new Cart();
        cart.initFromOrderList(orderList);

        System.out.println("\n------------------\nCart");
        cart.show();

        ReduceCostCalculator reduceCostCalculator = new ReduceCostCalculator();
        TWPOS twPOS = new TWPOS(twMarket.getItemList(), reduceCostCalculator);

        System.out.println("\n---------------------------------");
        twPOS.checkout(cart.getOrderList()).show();
    }
}

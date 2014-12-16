package habens.main;

import habens.market.TWMarket;
import habens.market.TWPOS;
import habens.promotion.DiscountPromotion;
import habens.promotion.SecondHalfPricePromotion;
import habens.util.*;
import habens.util.ParserImpl.CarParser;
import habens.util.ParserImpl.DiscountParser;
import habens.util.ParserImpl.SecondHalfPriceParser;
import habens.util.ParserImpl.StockParser;

import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class TestTWSCSS {
    public static void main(String[] args) {
        Parser parser;

        System.out.println("\n------------------\nMarket");
        parser = new StockParser();
        List<Stock> stockList = parser.parseFromFile("./src/main/resources/item_list.txt");
        TWMarket twMarket = new TWMarket(stockList);
        twMarket.show();

        parser = new DiscountParser();
        List<DiscountDetail> discountDetailList = parser.parseFromFile("./src/main/resources/discount_promotion.txt");
        DiscountPromotion discountPromotion = new DiscountPromotion(discountDetailList);

        parser = new SecondHalfPriceParser();
        List<String> secondHalfPriceIDList = parser.parseFromFile("./src/main/resources/second_half_price_promotion.txt");
        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(secondHalfPriceIDList);

        System.out.println("\n------------------\nDiscount Promotion");
        discountPromotion.show();

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

        TWPOS twPOS = new TWPOS(twMarket.getItemList());

        System.out.println("\n---------------------------------");
        twPOS.checkout(cart.getOrderList()).show();
    }
}

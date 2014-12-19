package habens.injector;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import habens.Calculator.ReduceCostCalculator;
import habens.item.Item;
import habens.parser.Parser;
import habens.parser.ParserImpl.CartParser;
import habens.parser.ParserImpl.DiscountParser;
import habens.parser.ParserImpl.SecondHalfPriceParser;
import habens.parser.ParserImpl.StockParser;
import habens.util.DiscountDetail;
import habens.util.Order;
import habens.util.Stock;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 12/17/14.
 */
public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<List<DiscountDetail>>(){})
                .annotatedWith(Names.named("discount"))
                .toInstance(Collections.unmodifiableList(new LinkedList<DiscountDetail>()));

        bind(new TypeLiteral<List<String>>(){})
                .annotatedWith(Names.named("secondHalfPrice"))
                .toInstance(Collections.unmodifiableList(new LinkedList<String>()));

        bind(new TypeLiteral<List<Stock>>(){})
                .annotatedWith(Names.named("stock"))
                .toInstance(Collections.unmodifiableList(new LinkedList<Stock>()));

        bind(new TypeLiteral<List<Order>>(){})
                .annotatedWith(Names.named("cart"))
                .toInstance(Collections.unmodifiableList(new LinkedList<Order>()));

        bind(new TypeLiteral<List<Item>>(){})
                .annotatedWith(Names.named("pos"))
                .toInstance(Collections.unmodifiableList(new LinkedList<Item>()));


        bind(Parser.class)
                .annotatedWith(Names.named("discount"))
                .to(DiscountParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("cart"))
                .to(CartParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("secondHalfPrice"))
                .to(SecondHalfPriceParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("stock"))
                .to(StockParser.class);
    }
}

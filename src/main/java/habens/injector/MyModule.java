package habens.injector;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.sun.istack.internal.NotNull;
import habens.parser.Parser;
import habens.parser.ParserImpl.CarParser;
import habens.parser.ParserImpl.DiscountParser;
import habens.parser.ParserImpl.SecondHalfPriceParser;
import habens.parser.ParserImpl.StockParser;
import habens.promotion.DiscountPromotion;
import habens.promotion.Promotion;
import habens.util.DiscountDetail;

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

        bind(Parser.class)
                .annotatedWith(Names.named("discount"))
                .to(DiscountParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("car"))
                .to(CarParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("secondHalfPrice"))
                .to(SecondHalfPriceParser.class);

        bind(Parser.class)
                .annotatedWith(Names.named("stock"))
                .to(StockParser.class);
    }
}

package habens.parser.ParserImpl;

import com.google.inject.Inject;
import habens.parser.Parser;
import habens.util.DiscountDetail;

/**
 * Created by habens on 12/4/14.
 */
public class DiscountParser extends Parser {

    @Inject
    public DiscountParser() {
    }

    protected DiscountDetail convert(String line) {
        String[] str = line.split(":");
        return new DiscountDetail(str[0], Integer.parseInt(str[1]));
    }
}

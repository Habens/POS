package habens.util.ParserImpl;

import habens.util.DiscountDetail;
import habens.util.Parser;

/**
 * Created by habens on 12/4/14.
 */
public class DiscountParser extends Parser {
    protected DiscountDetail convert(String line) {
        String[] str = line.split(":");
        return new DiscountDetail(str[0], Integer.parseInt(str[1]));
    }
}

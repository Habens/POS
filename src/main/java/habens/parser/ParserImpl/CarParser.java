package habens.parser.ParserImpl;

import habens.util.Order;
import habens.parser.Parser;

/**
 * Created by habens on 12/8/14.
 */
public class CarParser extends Parser {
    protected Order convert(String line) {
        if (line.contains("-")) {
            String[] str = line.split("-");
            return new Order(str[0], Integer.parseInt(str[1]));
        } else {
            return new Order(line, 1);
        }
    }
}

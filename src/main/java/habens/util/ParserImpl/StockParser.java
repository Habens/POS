package habens.util.ParserImpl;

import habens.item.Item;
import habens.item.NormalItem;
import habens.util.Parser;
import habens.util.Stock;

/**
 * Created by habens on 12/4/14.
 */
public class StockParser extends Parser {
    protected Stock convert(String line) {
        String[] str = line.split(":");
        Item itemTmp = new NormalItem(str[0], Integer.parseInt(str[1]));
        return new Stock(itemTmp, 100);
    }
}

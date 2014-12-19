package habens.promotion;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import habens.item.Item;
import habens.item.SecondHalfPriceItem;
import habens.parser.Parser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class SecondHalfPricePromotion implements Promotion {
    private List<String> secondHalfPriceIDList;
    private Parser secondHalfPriceParser;

    @Inject
    public SecondHalfPricePromotion(@Named("secondHalfPrice") List<String> secondHalfPriceIDList,
                                    @Named("secondHalfPrice") Parser secondHalfPriceParser) {
        this.secondHalfPriceIDList = secondHalfPriceIDList;
        this.secondHalfPriceParser = secondHalfPriceParser;
    }

    public void initFromFile(String filePath) {
        secondHalfPriceIDList = secondHalfPriceParser.parseFromFile(filePath);
    }

    public List<String> getItemIDList() {
        return secondHalfPriceIDList;
    }

    public SecondHalfPriceItem update(Item item) {
        return new SecondHalfPriceItem(item);
    }

    public void show() {
        for (String ID : secondHalfPriceIDList) {
            System.out.println(ID);
        }
    }
}

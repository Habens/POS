package habens.promotion;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import habens.item.DiscountItem;
import habens.item.Item;
import habens.parser.Parser;
import habens.util.DiscountDetail;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class DiscountPromotion implements Promotion {
    private List<DiscountDetail> discountDetailList;
    private Parser discountParser;

    @Inject
    public DiscountPromotion(@Named("discount") List<DiscountDetail> discountDetailList,
                             @Named("discount") Parser discountParser) {
        this.discountDetailList = discountDetailList;
        this.discountParser = discountParser;
    }

    public void initFormFile(String filePath) {
        discountDetailList = discountParser.parseFromFile(filePath);
    }

    public void setDiscountDetailList(List<DiscountDetail> discountDetailList) {
        this.discountDetailList = discountDetailList;
    }

    public List<DiscountDetail> getDiscountDetailList() {
        return discountDetailList;
    }

    public Parser getDiscountParser() {
        return discountParser;
    }

    public void setDiscountParser(Parser discountParser) {
        this.discountParser = discountParser;
    }

    public List<String> getItemIDList() {
        List<String> itemIDList = new LinkedList<String>();
        for (DiscountDetail discountDetail : discountDetailList) {
            itemIDList.add(discountDetail.getID());
        }
        return itemIDList;
    }

    public DiscountItem update(Item item) {
        return update(item, getDiscount(item.getID()));
    }

    public DiscountItem update(Item item, float discount) {
        return new DiscountItem(item, discount);
    }

    private float getDiscount(String discountItemID) {
        DiscountDetail discountDetail = getDetail(discountItemID);
        return discountDetail.getDiscount();
    }

    private DiscountDetail getDetail(String discountItemID) {
        for (int i = discountDetailList.size() - 1; i >= 0; i--) {
            if (discountDetailList.get(i).getID().equals(discountItemID)) {
                return discountDetailList.get(i);
            }
        }
        return null;
    }

    public void show() {
        for (DiscountDetail discountDetail : discountDetailList) {
            System.out.println(discountDetail.getID() + ":" + discountDetail.getDiscount());
        }
    }
}

package habens.promotion;


import habens.item.DiscountItem;
import habens.item.Item;
import habens.util.DiscountDetail;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class DiscountPromotion implements Promotion {
    private List<DiscountDetail> discountDetailList;

    public DiscountPromotion() {
        discountDetailList = new LinkedList<DiscountDetail>();
    }

    public DiscountPromotion(List<DiscountDetail> discountDetailList) {
        this.discountDetailList = discountDetailList;
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

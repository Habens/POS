package habens.util;

/**
 * Created by habens on 11/21/14.
 */
public class DiscountDetail {
    private String ItemID;
    private float discount;

    public DiscountDetail(String ItemID, float discount) {
        this.ItemID = ItemID;
        this.discount = discount;
    }

    public String getID() {
        return ItemID;
    }

    public float getDiscount() {
        return discount;
    }
}

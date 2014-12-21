package habens.util;

import java.util.List;

/**
 * Created by habens on 12/13/14.
 */
public class Result {
    private List<SubTotal> subTotalList;
    private float total;

    public Result(List<SubTotal> subTotalList, float total) {
        this.subTotalList = subTotalList;
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public void show() {
        for (SubTotal subTotal : subTotalList) {
            subTotal.show();
        }
        System.out.println(total);
    }
}

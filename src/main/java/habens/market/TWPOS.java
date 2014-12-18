package habens.market;


import habens.Calculator.ReduceCostCalculator;
import habens.exception.IsNotThisMarketItemException;
import habens.item.Item;
import habens.util.Order;
import habens.util.Result;
import habens.util.SubTotal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class TWPOS {
    private List<Item> itemList;
    private ReduceCostCalculator reduceCostCalculator;

    public TWPOS(List<Item> itemList, ReduceCostCalculator reduceCostCalculator) {
        this.itemList = itemList;
        this.reduceCostCalculator = reduceCostCalculator;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Result checkout(List<Order> orderList) {
        float total = 0;
        float totalWithoutPromotion = 0;
        float reduceTmp = 0;
        float reduce = 0;
        List<SubTotal> subTotalList = new LinkedList<SubTotal>();

        for (int i = orderList.size() - 1; i >= 0; i--) {
            Order orderTmp = orderList.get(i);

            Item itemTmp;
            try {
                itemTmp = getItemFromItemList(orderTmp.getID());
            } catch (IsNotThisMarketItemException e) {
                e.printStackTrace();
                continue;
            }

            float subtotal = itemTmp.cost(orderList.get(i).getNumber());

            /* 每满100返5元*/
            reduceTmp = reduceCostCalculator.calculate((int) subtotal, 5, 100);

            subtotal -= reduceTmp;
            total += subtotal;
            reduce += reduceTmp;

            totalWithoutPromotion += itemTmp.getPrice() * orderList.get(i).getNumber();

            subTotalList.add(new SubTotal(itemTmp.getID(),
                    orderTmp.getNumber(),
                    itemTmp.getPrice(),
                    itemTmp.getPrice() * orderList.get(i).getNumber(),
                    subtotal,
                    reduceTmp
            ));
        }

        /* 每满100返3元*/
        reduceTmp = reduceCostCalculator.calculate((int) total, 3, 100);
        total -= reduceTmp;
        return new Result(subTotalList, total);
    }

    private Item getItemFromItemList(String ID) throws IsNotThisMarketItemException {
        for (int i = itemList.size() - 1; i >= 0; i--) {
            if (itemList.get(i).getID().equals(ID)) {
                return itemList.get(i);
            }
        }
        throw new IsNotThisMarketItemException("The market contains not " + ID);
    }
}

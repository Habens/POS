package habens.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class Cart {
    private List<Order> orderList;

    public Cart() {
        orderList = new LinkedList<Order>();
    }

    public boolean initFromOrderList(List<Order> orderListTmp) {
        for (int i=orderListTmp.size()-1; i >=0; i--) {
            Order order = orderListTmp.get(i);
            add(order);
        }
        return true;
    }


    public List<Order> getOrderList() {
        return this.orderList;
    }

    private Order getOrderAbout(String ID) {
        for (int i = orderList.size() - 1; i >= 0; i--) {
            if (orderList.get(i).getID().equals(ID)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    private boolean add(Order order) {
        Order tmp = getOrderAbout(order.getID());
        if (null != tmp) {
            tmp.setNumber(tmp.getNumber() + order.getNumber());
            return true;
        } else {
            return orderList.add(order);
        }
    }

    public void show() {
        for (Order order:orderList) {
            System.out.println(order.getID() + ":" + order.getNumber());
        }
    }
}

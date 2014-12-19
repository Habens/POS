package habens.util;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import habens.parser.Parser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public class Cart {
    private List<Order> orderList;
    private Parser cartParser;

    @Inject
    public Cart(@Named("cart") List<Order> orderList,
                @Named("cart") Parser cartParser) {
        this.orderList = orderList;
        this.cartParser = cartParser;
    }

    public void initFromFile(String filePath) {
        List<Order> orderListTmp = cartParser.parseFromFile(filePath);
        orderList = adjustOrderList(orderListTmp);
    }

    /**
     * 之所以有这么奇怪的写法，是因为 Guice 返回的List初始化后是 UnmodifiableCollection
     * 不能改动(eg.add or delete)的，所以只能利用这样的方式初始化。
     */
    private List<Order> adjustOrderList(List<Order> orderList) {
        List<Order> orderListTmp = new LinkedList<Order>();
        for (int i=orderList.size()-1; i >=0; i--) {
            Order order = orderList.get(i);
            add(orderListTmp, order);
        }
        return orderListTmp;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    private Order getOrderAbout(List<Order> orderList, String ID) {
        for (int i = orderList.size() - 1; i >= 0; i--) {
            if (orderList.get(i).getID().equals(ID)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    private void add(List<Order> orderList, Order order) {
        Order tmp = getOrderAbout(orderList, order.getID());
        if (null != tmp) {
            tmp.setNumber(tmp.getNumber() + order.getNumber());
        } else {
            orderList.add(order);
        }
    }

    public void show() {
        for (Order order:orderList) {
            System.out.println(order.getID() + ":" + order.getNumber());
        }
    }
}

package habens.util;

/**
 * Created by habens on 11/21/14.
 */
public class Order {

    private String ID;
    private int number;

    public Order(String ID, int number) {
        this.ID = ID;
        this.number = number;
    }

    public String getID() {
        return ID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

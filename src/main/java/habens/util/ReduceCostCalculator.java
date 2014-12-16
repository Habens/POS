package habens.util;

/**
 * Created by habens on 11/26/14.
 */
public class ReduceCostCalculator {
    public int calculate(int cost, int reduce, int each) {
        return (cost/each) * reduce;
    }
}

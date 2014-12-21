package util;

import habens.Calculator.ReduceCostCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReduceCostCalculatorTest {

    @Test
    public void should_get_right_cost_when_given_a_reduce_rule() throws Exception {
        ReduceCostCalculator reduceCostCalculator = new ReduceCostCalculator();
        float originalCost = 100;
        int reduce = 3;
        int reduceConditions = 100;

        int reduceCost = reduceCostCalculator.calculate((int) originalCost,
                reduce,
                reduceConditions);

        assertEquals(reduceCost, 3, 0.01);
    }
}
package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void twoPlusTwoShouldEqualFour(){
        int actualValue = Calculator.add(2, 2);
        int expectedValue = 4;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void threePlusFiveShouldEqualsEight(){
        int actualValue = Calculator.add(3, 5);
        int expectedValue = 8;
        assertEquals(expectedValue, actualValue);
    }

}

package com.mycompany.stringcalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringAppTest {
   @Test
    void testEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
    
    @Test
    void testSingleNumberReturnsValue() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }
    
    @Test
    void testTwoNumbersReturnSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
}

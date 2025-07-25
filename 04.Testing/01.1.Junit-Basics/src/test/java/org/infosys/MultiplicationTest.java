package org.infosys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {
    @Test
//    @Tag("Success")
    @DisplayName("Multiply Test")
    @Tag("Failure")
    @Tag("Slow")
    void testMultiply(){
        CalculationUtil calculationUtil = new CalculationUtil();
        int actual=calculationUtil.multiply(10,20);
        int expected=200;
        Assertions.assertEquals(expected,actual,"Not equal values");
    }
}

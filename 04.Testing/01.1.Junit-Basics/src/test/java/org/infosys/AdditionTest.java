package org.infosys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AdditionTest {
    @Test
    @Tag("Success")
    @DisplayName("AddInt")
    void testAdd(){
        CalculationUtil calculationUtil = new CalculationUtil();
        int actual=calculationUtil.add(10,20);
        int expected=30;
        Assertions.assertEquals(expected,actual,"Not equal values");
    }
}

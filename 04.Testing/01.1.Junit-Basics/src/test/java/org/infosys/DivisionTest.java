package org.infosys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DivisionTest {
    @Test
    @Tag("Success")
    void testDivException(){
        CalculationUtil calculationUtil = new CalculationUtil();
//        Assertions.assertThrows(ArithmeticException.class, () -> calculationUtil.divide(10,0));
        Assertions.assertDoesNotThrow(() -> calculationUtil.divide(10,2),"error in code");
    }
}

package com.infosys;

import com.infosys.Entity.Calculator;
import com.infosys.Service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CalculatorTest {
    Calculator c=null;
    CalculatorService service= Mockito.mock(CalculatorService.class);
    @BeforeEach
    public void setup(){
        c=new Calculator(service);
    }

    @Test
    void testPerform(){
        when(service.divide(10,0))
                .thenThrow(ArithmeticException.class);
        Assertions.assertThrows(ArithmeticException.class,
                ()-> service.divide(10,0));
    }
}

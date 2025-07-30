package com.infosys;

import com.infosys.Entity.Calculator1;
import com.infosys.Service.CalculatorService1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class CalculatorTest1 {
    Calculator1 c=null;
    CalculatorService1 service= Mockito.mock(CalculatorService1.class);

    @BeforeEach
    public void setup(){
        c=new Calculator1(service);
    }

    @Test
    public void testPerform(){
        doNothing().when(service).add(0,0);
        c.perform(0,0);
        verify(service).add(0,0);
    }
}

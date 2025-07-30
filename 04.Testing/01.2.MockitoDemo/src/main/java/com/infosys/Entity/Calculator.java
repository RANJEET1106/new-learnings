package com.infosys.Entity;

import com.infosys.Service.CalculatorService;

public class Calculator {
    CalculatorService calculatorService;
    public Calculator(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    public int getDivision(int x, int y){
        return calculatorService.divide(x,y);
    }

}

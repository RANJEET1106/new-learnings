package com.infosys.capstone.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BonusService implements BonusServiceInterface {
    @Value("${bonus.multiplier.standard}")
    private double standardMultiplier;

    @Value("${bonus.multiplier.executive}")
    private double executiveMultiplier;

    @Override
    public void standardBonusService(Integer rating) {

        System.out.println("Bonus is "+rating*standardMultiplier);
    }

    @Override
    public void executiveBonusService(Integer rating) {
        System.out.println("Bonus is "+rating*executiveMultiplier);
    }
}

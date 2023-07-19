package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;

public class DefaultPensioenServiceImpl implements PensioenService {

   @Override
   public BigDecimal calculateYearlyContribution(BigDecimal salary, BigDecimal franchise, BigDecimal parttimePercentage,
                                                 BigDecimal premiumPercentage) {
      BigDecimal sourceForCalculation = salary.subtract(franchise);
      return sourceForCalculation.multiply(parttimePercentage).multiply(premiumPercentage);
   }
}

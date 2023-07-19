package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;

public interface PensioenService {

  /**
   * @param parttimePercentage - value between 0 and 1
   * @param premiumPercentage - value between 0 and 1
   */
  BigDecimal calculateYearlyContribution(
      BigDecimal salary, BigDecimal franchise, BigDecimal parttimePercentage, BigDecimal premiumPercentage);


}

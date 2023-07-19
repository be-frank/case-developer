package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.random.RandomGenerator;

public class MockBeleggingsServiceImpl implements BeleggingsService {

  private final Map<Long, BigDecimal> mockData =
      Map.of(
          10001L, new BigDecimal("100000.00"),
          10002L, new BigDecimal("250000.00"),
          10003L, new BigDecimal("174726.84"));

   private final RandomGenerator random = RandomGenerator.getDefault();

   @Override
   public BigDecimal getValue(Long accountNumber) {
      if (accountNumber < 1000) {
         throw new IllegalArgumentException("Invalid account number " + accountNumber);
      }
      return Optional.ofNullable(mockData.get(accountNumber)).orElseGet(this::newRandomBigDecimal);
   }

   BigDecimal newRandomBigDecimal() {
      BigDecimal randFromDouble = BigDecimal.valueOf(this.random.nextLong());
      return randFromDouble
              .setScale(2, RoundingMode.HALF_UP);
   }
}

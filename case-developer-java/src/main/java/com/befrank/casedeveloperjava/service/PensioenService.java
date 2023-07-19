package com.befrank.casedeveloperjava.service;

import com.befrank.casedeveloperjava.Deelnemer;
import java.math.BigDecimal;
import org.springframework.lang.NonNull;

public interface PensioenService {

  @NonNull
  BigDecimal calculateYearlyContribution(Deelnemer deelnemer);

  @NonNull
  BigDecimal calculateTotalEstimateForEndDate(Deelnemer deelnemer, Integer plannedRetirementAge);
}

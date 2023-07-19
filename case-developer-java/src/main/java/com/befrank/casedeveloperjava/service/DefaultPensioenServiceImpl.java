package com.befrank.casedeveloperjava.service;

import com.befrank.casedeveloperjava.Deelnemer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPensioenServiceImpl implements PensioenService {

  private static final BigDecimal YEARLY_INTEREST_PERCENTAGE = new BigDecimal("0.03");

  private final BeleggingsService beleggingsService;

  @Autowired
  public DefaultPensioenServiceImpl(BeleggingsService beleggingsService) {
    this.beleggingsService = beleggingsService;
  }

  @Override
  public BigDecimal calculateYearlyContribution(Deelnemer deelnemer) {
    Objects.requireNonNull(deelnemer);

    // Indien de deelnemer uit dienst is, dan wordt er geen premie meer gestort
    if (!isDeelnemerInService(deelnemer)) {
      return BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);
    }

    BigDecimal sourceForCalculation =
        deelnemer.getServiceFulltimeSalary().subtract(deelnemer.getServiceFranchise());
    return sourceForCalculation
        .multiply(deelnemer.getServiceParttimePercentage())
        .multiply(deelnemer.getServicePremiumPercentage());
  }

  public BigDecimal calculateTotalEstimateForEndDate(
      Deelnemer deelnemer, Integer plannedRetirementAge) {
    Objects.requireNonNull(deelnemer);
    Objects.requireNonNull(plannedRetirementAge);

    BigDecimal currentTotal =
        beleggingsService.getValue(deelnemer.getServicePensionAccountNumber());
    BigDecimal yearlyGrowth = calculateYearlyContribution(deelnemer);

    LocalDate retirementDate = deelnemer.getBirthDate().plusYears(plannedRetirementAge);

    long yearsToGo = ChronoUnit.YEARS.between(LocalDate.now(), retirementDate);
    BigDecimal estimatedTotal = currentTotal;
    for (long i = 0; i < yearsToGo; i++) {
      estimatedTotal = calculateExpectedValue(yearlyGrowth, estimatedTotal);
    }
    return estimatedTotal.setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal calculateExpectedValue(BigDecimal yearlyGrowth, BigDecimal currentValue) {
    // Huidige waarde + Jaarlijkse premiestorting + (Huidige waarde + Jaarlijkse premiestorting/2) * rendement
    BigDecimal intermediate = currentValue.add(yearlyGrowth.divide(new BigDecimal("2.00"), RoundingMode.HALF_UP)).multiply(YEARLY_INTEREST_PERCENTAGE);
    return currentValue.add(yearlyGrowth).add(intermediate);
  }

  private static boolean isDeelnemerInService(Deelnemer deelnemer) {
    return deelnemer.getServiceEndDate() == null
        || LocalDate.now().isBefore(deelnemer.getServiceEndDate());
  }
}

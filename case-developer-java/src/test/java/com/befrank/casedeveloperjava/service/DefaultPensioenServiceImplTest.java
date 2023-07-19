package com.befrank.casedeveloperjava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import com.befrank.casedeveloperjava.Deelnemer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultPensioenServiceImplTest {
  @Mock private BeleggingsService beleggingsService;

  private PensioenService pensioenService;

  @BeforeEach
  void setUp() {
    this.pensioenService = new DefaultPensioenServiceImpl(this.beleggingsService);
  }

  @ParameterizedTest
  @MethodSource("provideDataForcalculateTotalEstimateForEndDateShouldGiveRightAmount")
  void calculateTotalEstimateForEndDateShouldGiveRightAmount(
      Deelnemer deelnemer,
      BigDecimal currentPensionValue,
      Integer retirementAge,
      BigDecimal expectedAmount) {
    given(this.beleggingsService.getValue(anyLong())).willReturn(currentPensionValue);
    var estimatedTotalAmount =
        this.pensioenService.calculateTotalEstimateForEndDate(deelnemer, retirementAge);
    assertEquals(expectedAmount, estimatedTotalAmount);
  }

  private static Stream<Arguments>
      provideDataForcalculateTotalEstimateForEndDateShouldGiveRightAmount() {
    // Arguments: deelnemer, currentPensionValue, retirementAge, expectedAmount
    return Stream.of(
        Arguments.of(
            getTestDeelnemer(LocalDate.now().minusYears(60)),
            new BigDecimal("100000.00"),
            61,
            new BigDecimal("104802.68")),
        Arguments.of(
            getTestDeelnemer(LocalDate.now().minusYears(60).minusDays(45)),
            new BigDecimal("100000.00"),
            61,
            new BigDecimal("104802.68")),
        Arguments.of(
            getTestDeelnemer(LocalDate.now().minusYears(61)),
            new BigDecimal("100000.00"),
            61,
            new BigDecimal("100000.00")),
        Arguments.of(
            getTestDeelnemer(LocalDate.now().minusYears(61).minusDays(45)),
            new BigDecimal("100000.00"),
            61,
            new BigDecimal("100000.00")),
        Arguments.of(
            getTestDeelnemer(LocalDate.now().minusYears(60)),
            new BigDecimal("100000.00"),
            65,
            new BigDecimal("125498.08")));
  }

  private static Deelnemer getTestDeelnemer(LocalDate birthDate) {
    var testDeelnemer = new Deelnemer();
    testDeelnemer.setName("Henk" + RandomGenerator.getDefault().nextInt());
    testDeelnemer.setBirthDate(birthDate);
    testDeelnemer.setServiceFulltimeSalary(new BigDecimal("60000"));
    testDeelnemer.setServiceParttimePercentage(new BigDecimal("0.80"));
    testDeelnemer.setServiceFranchise(new BigDecimal("15599.00"));
    testDeelnemer.setServicePremiumPercentage(new BigDecimal("0.05"));
    testDeelnemer.setServiceInvestmentAccount(RandomGenerator.getDefault().nextLong());
    return testDeelnemer;
  }
}

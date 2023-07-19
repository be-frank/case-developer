package com.befrank.casedeveloperjava.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockBeleggingsServiceImplTest {

  private BeleggingsService beleggingsService;

  @BeforeEach
  void setUp() {
    this.beleggingsService = new MockBeleggingsServiceImpl();
  }

  @Test
  void failsOnInvalidAccountnumbers() {
    assertThrows(IllegalArgumentException.class, () -> beleggingsService.getValue(-15L));
    assertThrows(IllegalArgumentException.class, () -> beleggingsService.getValue(0L));
    assertThrows(IllegalArgumentException.class, () -> beleggingsService.getValue(15L));
    assertThrows(IllegalArgumentException.class, () -> beleggingsService.getValue(999L));
  }

  @Test
  void succeedsWithValidWithFixedValueAccountnumber() {
    BigDecimal foundAmount = beleggingsService.getValue(10001L);
    assertNotNull(foundAmount);
    assertEquals(2, foundAmount.scale());
    assertEquals(100000, foundAmount.longValue());
    assertEquals(0, foundAmount.remainder(BigDecimal.ONE).intValue());
  }

  @Test
  void succeedsWithValidRandomValueAccountnumber() {
    BigDecimal foundAmount = beleggingsService.getValue(9999999999L);
    assertNotNull(foundAmount);
    assertEquals(2, foundAmount.scale());
    assertTrue(foundAmount.longValue() >= 0);
    assertTrue(foundAmount.remainder(BigDecimal.ONE).intValue() >= 0);
  }
}

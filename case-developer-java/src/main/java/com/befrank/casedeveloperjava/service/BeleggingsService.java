package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

public interface BeleggingsService {

  @NonNull
  BigDecimal getValue(Long accountNumber);
}

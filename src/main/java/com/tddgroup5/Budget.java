package com.tddgroup5;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Budget {
  private String yearMonth;
  private int amount;

  public Budget(String yearMonth, int amount) {
    this.yearMonth = yearMonth;
    this.amount = amount;
  }

  public double overlappingAmount(Period period) {
    return daliyAmount() * period.getOverlappingDays(createPeriod());
  }

  private String getYearMonth() {
    return yearMonth;
  }

  private int getAmount() {
    return amount;
  }

  private YearMonth getMonth() {
    return YearMonth.parse(getYearMonth(), DateTimeFormatter.ofPattern("yyyyMM"));
  }

  private LocalDate firstDay() {
    return getMonth().atDay(1);
  }

  private LocalDate lastDay() {
    return getMonth().atEndOfMonth();
  }

  private double daliyAmount() {
    return getAmount() / getMonth().lengthOfMonth();
  }

  private Period createPeriod() {
    return new Period(firstDay(), lastDay());
  }

}

package com.tddgroup5;

import java.time.YearMonth;

public class Budget {
  private YearMonth yearMonth;
  private int amount;

  public Budget(YearMonth yearMonth, int amount) {

    this.yearMonth = yearMonth;
    this.amount = amount;
  }

  public void setYearMonth(YearMonth yearMonth) {
    this.yearMonth = yearMonth;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public YearMonth getYearMonth() {
    return yearMonth;
  }

  public int getAmount() {
    return amount;
  }
}

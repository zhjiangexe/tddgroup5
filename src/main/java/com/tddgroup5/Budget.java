package com.tddgroup5;

public class Budget {
  private String yearMonth;
  private int amount;

  public Budget(String yearMonth, int amount) {
    this.yearMonth = yearMonth;
    this.amount = amount;
  }

  public String getYearMonth() {
    return yearMonth;
  }

  public void setYearMonth(String yearMonth) {
    this.yearMonth = yearMonth;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}

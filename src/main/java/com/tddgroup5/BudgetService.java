package com.tddgroup5;

import java.time.LocalDate;

public class BudgetService {
  private final BudgetRepo budgetRepo;

  public BudgetService(BudgetRepo budgetRepo) {
    this.budgetRepo = budgetRepo;
  }

  public double query(LocalDate start, LocalDate end) {
    Period period = new Period(start, end);
    return budgetRepo.getAll().stream()
        .mapToDouble(budget -> budget.overlappingAmount(period))
        .sum();
  }

}

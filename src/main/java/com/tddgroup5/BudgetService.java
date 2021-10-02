package com.tddgroup5;

import java.time.LocalDate;

public class BudgetService {
  private final BudgetRepo budgetRepo;

  public BudgetService(BudgetRepo budgetRepo) {
    this.budgetRepo = budgetRepo;
  }


  public double query(LocalDate start, LocalDate end) {
    return budgetRepo.getAll().get(0).getAmount();
  }
}

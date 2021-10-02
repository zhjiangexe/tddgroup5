package com.tddgroup5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetServiceTest {

  private BudgetService budgetService;
  private BudgetRepo budgetRepo;

  @BeforeEach
  void setUp() {
    budgetRepo = mock(BudgetRepo.class);
    budgetService = new BudgetService(budgetRepo);
  }

  @Test
  void query_whole_month() {
    when(budgetRepo.getAll()).thenReturn(new ArrayList<Budget>() {{
      add(new Budget(YearMonth.of(2020, 1), 310));
    }});

    LocalDate start = LocalDate.of(2020, 1, 1);
    LocalDate end = LocalDate.of(2020, 1, 31);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(310);
  }

  @Test
  void query_cross_month() {
    when(budgetRepo.getAll()).thenReturn(new ArrayList<Budget>() {{
      add(new Budget(YearMonth.of(2020, 3), 310));
      add(new Budget(YearMonth.of(2020, 4), 300));
    }});
    LocalDate start = LocalDate.of(2020, 3, 31);
    LocalDate end = LocalDate.of(2020, 4, 1);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(20);
  }
}

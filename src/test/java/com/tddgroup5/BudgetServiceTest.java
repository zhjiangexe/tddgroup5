package com.tddgroup5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BudgetServiceTest {

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
      add(new Budget("202001", 310));
    }});

    LocalDate start = LocalDate.of(2020, 1, 1);
    LocalDate end = LocalDate.of(2020, 1, 31);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(310);
  }

  @Test
  void query_cross_month() {
    when(budgetRepo.getAll()).thenReturn(new ArrayList<Budget>() {{
      add(new Budget("202003", 310));
      add(new Budget("202004", 3000));
      add(new Budget("202005", 31000));
    }});
    LocalDate start = LocalDate.of(2020, 3, 31);
    LocalDate end = LocalDate.of(2020, 5, 1);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(4010);
  }

  @Test
  void endDate_is_before_startDate() {
    LocalDate end = LocalDate.of(2020, 3, 2);
    LocalDate start = LocalDate.of(2020, 3, 3);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(0);
  }

  @Test
  void out_of_subset() {
    when(budgetRepo.getAll()).thenReturn(new ArrayList<Budget>() {{
      add(new Budget("202004", 300));
    }});
    LocalDate start = LocalDate.of(2020, 2, 1);
    LocalDate end = LocalDate.of(2020, 3, 2);

    double result = budgetService.query(start, end);

    assertThat(result).isEqualTo(0);
  }
}

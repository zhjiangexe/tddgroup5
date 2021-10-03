package com.tddgroup5;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Period {
  private final LocalDate start;
  private final LocalDate end;

  public Period(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
  }

  public double getOverlappingDays(Period another) {
    if (isNotInPeriod(another) || invalid()) {
      return 0;
    }
    LocalDate overlappingStart = start.isAfter(another.start) ? start : another.start;
    LocalDate overlappingEnd = end.isBefore(another.end) ? end : another.end;
    return (double) DAYS.between(overlappingStart, overlappingEnd) + 1;
  }

  private boolean invalid() {
    return start.isAfter(end);
  }

  private boolean isNotInPeriod(Period another) {
    return end.isBefore(another.start) || start.isAfter(another.end);
  }
}

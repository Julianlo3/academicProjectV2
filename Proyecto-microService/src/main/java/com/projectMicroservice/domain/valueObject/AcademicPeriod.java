package com.projectMicroservice.domain.valueObject;

import java.util.Objects;

public class AcademicPeriod {

    private final int year;
    private final int term; // 1 or 2

    public AcademicPeriod(int year, int term) {
        if (term < 1 || term > 2) {
            throw new IllegalArgumentException("El término debe ser 1 o 2.");
        }
        this.year = year;
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }

    public boolean isBefore(AcademicPeriod other) {
        return this.year < other.year || (this.year == other.year && this.term < other.term);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AcademicPeriod)) return false;
        AcademicPeriod other = (AcademicPeriod) o;
        return year == other.year && term == other.term;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, term);
    }

    @Override
    public String toString() {
        return year + "-" + term;
    }
}
package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AcademicPeriodEmbeddable {

    private int year;
    private int term;

    public AcademicPeriodEmbeddable(int year, int term) {
        this.year = year;
    }

    public AcademicPeriodEmbeddable() {}

    // Getters y setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}

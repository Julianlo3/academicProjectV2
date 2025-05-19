package com.projectMicroservice.domain.valueObject;

import jakarta.persistence.Embeddable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TechnologyStack {

    private final List<String> technologies;

    public TechnologyStack(List<String> technologies) {
        if (technologies == null || technologies.isEmpty()) {
            throw new IllegalArgumentException("Debe incluir al menos una tecnología.");
        }
        this.technologies = List.copyOf(technologies);
    }

    public List<String> getTechnologies() {
        return Collections.unmodifiableList(technologies);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TechnologyStack)) return false;
        TechnologyStack other = (TechnologyStack) o;
        return technologies.equals(other.technologies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technologies);
    }
}
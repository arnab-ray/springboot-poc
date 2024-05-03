package io.arnab.drools.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;

@PlanningEntity
public record Lecture(Integer availableRooms, Integer availablePeriods) {
}

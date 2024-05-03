package io.arnab.drools.optaplanner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

import java.util.HashSet;
import java.util.Set;

public class ScoreCalculator implements EasyScoreCalculator<CourseSchedule, HardSoftScore> {
    @Override
    public HardSoftScore calculateScore(CourseSchedule courseSchedule) {
        int hardScore = 0;
        int softScore = 0;

        Set<String> occupiedRooms = new HashSet<>();
        for (Lecture lecture : courseSchedule.getLectureList()) {
            if(lecture.availablePeriods() != null && lecture.availableRooms() != null) {
                String roomInUse = lecture.availablePeriods() + ":" + lecture.availableRooms();
                if (occupiedRooms.contains(roomInUse)) {
                    hardScore += -1;
                } else {
                    occupiedRooms.add(roomInUse);
                }
            } else {
                hardScore += -1;
            }
        }

        return HardSoftScore.of(hardScore, softScore);
    }
}

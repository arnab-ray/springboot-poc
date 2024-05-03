package io.arnab.drools;

import io.arnab.drools.optaplanner.CourseSchedule;
import io.arnab.drools.optaplanner.Lecture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.util.Arrays;

public class OptaPlannerLongRunningUnitTest {
    static CourseSchedule unsolvedCourseSchedule;

    @BeforeAll
    public static void setUp() {

        unsolvedCourseSchedule = new CourseSchedule();

        for(int i = 0; i < 10; i++){
            unsolvedCourseSchedule.getLectureList().add(new Lecture(0, 0));
        }

        unsolvedCourseSchedule.getPeriodList().addAll(Arrays.asList(1, 2, 3));
        unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(1, 2));
    }

//    @Test
//    public void test_whenCustomJavaSolver() {
//        SolverFactory<CourseSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfiguration.xml");
//        Solver<CourseSchedule> solver = solverFactory.buildSolver();
//        CourseSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);
//
//        Assertions.assertThat(solvedCourseSchedule.getScore()).isNotNull();
//        Assertions.assertThat(solvedCourseSchedule.getScore().getHardScore()).isEqualTo(-4);
//    }
//
//    @Test
//    public void test_whenDroolsSolver() {
//        SolverFactory<CourseSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfigDrools.xml");
//        Solver<CourseSchedule> solver = solverFactory.buildSolver();
//        CourseSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);
//
//        Assertions.assertThat(solvedCourseSchedule.getScore()).isNotNull();
//        Assertions.assertThat(solvedCourseSchedule.getScore().getHardScore()).isEqualTo(0);
//    }
}

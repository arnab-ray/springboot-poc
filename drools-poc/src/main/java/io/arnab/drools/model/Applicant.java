package io.arnab.drools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {
    String name;
    int age;
    double currentSalary;
    int experienceInYears;
}

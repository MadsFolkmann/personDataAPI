package edu.exercise.persondataapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameResponseDTO {
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private double genderProbability;
    private int age;
    private double ageProbability;
    private String country;
    private double countryProbability;
}

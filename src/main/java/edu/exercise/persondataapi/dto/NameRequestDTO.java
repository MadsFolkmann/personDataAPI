package edu.exercise.persondataapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NameRequestDTO {
    private String firstName;
    private String middleName;
    private String lastName;
}

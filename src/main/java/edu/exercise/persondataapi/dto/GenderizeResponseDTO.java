package edu.exercise.persondataapi.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenderizeResponseDTO {
    private String name;
    private String gender;
    private double probability;
    private int count;
}

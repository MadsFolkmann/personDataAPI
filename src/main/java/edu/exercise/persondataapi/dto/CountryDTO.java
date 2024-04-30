package edu.exercise.persondataapi.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
        private String country_id;
        private double probability;
}

package edu.exercise.persondataapi.dto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NationalizeResponseDTO {
    private String name;
    private List<CountryDTO> country;
    private int count;

}

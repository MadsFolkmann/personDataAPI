package edu.exercise.persondataapi.service;

import edu.exercise.persondataapi.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {

    private final GenderizeService genderizeService;
    private final AgifyService agifyService;
    private final NationalizeService nationalizeService;

    public NameService(GenderizeService genderizeService, AgifyService agifyService, NationalizeService nationalizeService) {
        this.genderizeService = genderizeService;
        this.agifyService = agifyService;
        this.nationalizeService = nationalizeService;
    }

    public NameResponseDTO getNameInfo(NameRequestDTO request) {
        String fullName = buildFullName(request);

        // Call Genderize API
        GenderizeResponseDTO genderizeResponse = genderizeService.getGender(request.getFirstName());

        // Call Agify API
        AgifyResponseDTO agifyResponse = agifyService.getAge(request.getFirstName());

        // Call Nationalize API
        NationalizeResponseDTO nationalizeResponse = nationalizeService.getNationality(request.getFirstName());

        // Combine responses into NameResponse
        NameResponseDTO response = new NameResponseDTO();
        response.setFullName(fullName);
        response.setFirstName(request.getFirstName());
        response.setMiddleName(request.getMiddleName());
        response.setLastName(request.getLastName());

        //Setting gender and Probability
        response.setGender(genderizeResponse.getGender());
        response.setGenderProbability(genderizeResponse.getProbability());

        //Setting Age
        response.setAge(agifyResponse.getAge());
        //Setting Country and Probability
        System.out.println(nationalizeResponse.toString());
        if (nationalizeResponse.getCountry() != null && !nationalizeResponse.getCountry().isEmpty()) {
            List<CountryDTO> countries = nationalizeResponse.getCountry();
            CountryDTO mostProbableCountry = countries.get(0); // Assuming the most probable country is the first one
            response.setCountry(mostProbableCountry.getCountry_id());
            response.setCountryProbability(mostProbableCountry.getProbability());
        }

        return response;
    }

    private String buildFullName(NameRequestDTO request) {
        StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(request.getFirstName());
        if (request.getMiddleName() != null && !request.getMiddleName().isEmpty()) {
            fullNameBuilder.append(" ").append(request.getMiddleName());
        }
        fullNameBuilder.append(" ").append(request.getLastName());
        return fullNameBuilder.toString();
    }
}


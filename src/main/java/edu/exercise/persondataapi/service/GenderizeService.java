package edu.exercise.persondataapi.service;

import edu.exercise.persondataapi.dto.GenderizeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenderizeService {

    private final RestTemplate restTemplate;

    public GenderizeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GenderizeResponseDTO getGender(String name) {
        String url = "https://api.genderize.io?name=" + name;
        return restTemplate.getForObject(url, GenderizeResponseDTO.class);
    }
}
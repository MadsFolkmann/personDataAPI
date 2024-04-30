package edu.exercise.persondataapi.service;


import edu.exercise.persondataapi.dto.NationalizeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NationalizeService {

    private final RestTemplate restTemplate;

    public NationalizeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NationalizeResponseDTO getNationality(String name) {
        String url = "https://api.nationalize.io?name=" + name;
        return restTemplate.getForObject(url, NationalizeResponseDTO.class);
    }
}
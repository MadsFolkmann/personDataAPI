package edu.exercise.persondataapi.service;

import edu.exercise.persondataapi.dto.AgifyResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgifyService {
    private final RestTemplate restTemplate;

    public AgifyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AgifyResponseDTO getAge(String name) {
        String url = "https://api.agify.io?name=" + name;
        return restTemplate.getForObject(url, AgifyResponseDTO.class);
    }

}

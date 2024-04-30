package edu.exercise.persondataapi.controller;
import edu.exercise.persondataapi.dto.NameRequestDTO;
import edu.exercise.persondataapi.dto.NameResponseDTO;
import edu.exercise.persondataapi.service.NameService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name")
public class NameController {

    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/info")
    public ResponseEntity<NameResponseDTO> getNameInfo(@RequestBody NameRequestDTO request) {
        NameResponseDTO response = nameService.getNameInfo(request);
        return ResponseEntity.ok(response);
    }
}

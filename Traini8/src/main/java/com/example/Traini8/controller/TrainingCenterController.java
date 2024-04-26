package com.example.Traini8.controller;

import com.example.Traini8.entity.TrainingCenter;
import com.example.Traini8.dto.UserRequest;
import com.example.Traini8.exception.TrainingCenterNotFoundException;
import com.example.Traini8.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
/**
 * Controller class responsible for handling HTTP requests related to Training Centers.
 */

@RestController
@RequestMapping("/trainingCenters") // the base path
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

    @PostMapping("/signup") //Endpoint to register a new Training Center
    public ResponseEntity<TrainingCenter> saveTrainingCenter(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveTrainingCenter(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/search")//Endpoint to search Training Centers based on Name, City, State, Courses Offered
    public ResponseEntity<List<TrainingCenter>> searchTrainingCenters(
            @RequestParam(required = false) String centerName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) List<String> coursesOffered) {

        // Delegate search and filtering logic to the service layer
        List<TrainingCenter> filteredCenters = service.findTrainingCenters(centerName, city, state, coursesOffered);

        // Return the filtered results
        return ResponseEntity.ok(filteredCenters);
    }

    @GetMapping("/fetchAll")//Endpoint to fetch all saved Training Centers
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(){
        return ResponseEntity.ok(service.getAllTrainingCenters());
    }

    @GetMapping("/{centerName}")//Endpoint to fetch Training Center details by name
    public ResponseEntity<TrainingCenter> getTrainingCenter(@PathVariable String centerName) throws TrainingCenterNotFoundException {
        return ResponseEntity.ok(service.getTrainingCenter(centerName));
    }
}

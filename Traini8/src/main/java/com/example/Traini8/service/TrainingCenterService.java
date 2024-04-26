// TrainingCenterService.java
package com.example.Traini8.service;

import com.example.Traini8.entity.TrainingCenter;
import com.example.Traini8.dto.UserRequest;
import com.example.Traini8.exception.TrainingCenterNotFoundException;
import com.example.Traini8.repo.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Service
public class TrainingCenterService {

    private final MongoTemplate mongoTemplate;


    public List<TrainingCenter> findTrainingCenters(String centerName, String city, String state, List<String> coursesOffered) {
        // Constructing a query based on the provided criteria
        Query query = new Query();

        if (centerName != null) {
            query.addCriteria(Criteria.where("centerName").is(centerName));
        }

        if (city != null) {
            query.addCriteria(Criteria.where("address.city").is(city));
        }

        if (state != null) {
            query.addCriteria(Criteria.where("address.state").is(state));
        }

        if (coursesOffered != null && !coursesOffered.isEmpty()) {
            query.addCriteria(Criteria.where("coursesOffered").in(coursesOffered));
        }

        // Execute the query
        return mongoTemplate.find(query, TrainingCenter.class);
    }
    @Autowired
    public TrainingCenterService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter saveTrainingCenter(UserRequest userRequest) {
        // TrainingCenter object using the provided userRequest data
        TrainingCenter trainingCenter = new TrainingCenter(
                userRequest.getCenterName(),
                userRequest.getCenterCode(),
                userRequest.getStudentCapacity(),
                userRequest.getCoursesOffered(),
                userRequest.getContactEmail(),
                userRequest.getContactPhone(),
                userRequest.getAddress(),
                System.currentTimeMillis() // Using Epoch time to populate createdOn
        );

        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters(){
        return repository.findAll();
    }

    public TrainingCenter getTrainingCenter(String centerName) throws TrainingCenterNotFoundException {
        // Find the TrainingCenter by its name
        return (TrainingCenter) repository.findByCenterName(centerName)
                .orElseThrow(() -> new TrainingCenterNotFoundException("Training center not found with id: " + centerName));
    }
}

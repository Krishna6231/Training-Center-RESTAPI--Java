// UserRepository.java
package com.example.Traini8.repo;

import com.example.Traini8.entity.TrainingCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String> {
    Optional<Object> findByCenterName(String centerName);

}

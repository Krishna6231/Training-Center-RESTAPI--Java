// UserRepository.java
package com.example.Traini8.repo;

import com.example.Traini8.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByCenterId(int id);
}

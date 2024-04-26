package com.example.Traini8.service;

import com.example.Traini8.entity.User;
import com.example.Traini8.dto.UserRequest;
import com.example.Traini8.exception.UserNotFoundException;
import com.example.Traini8.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(
                0,
                userRequest.getCenterName(),
                userRequest.getCenterCode(),
                userRequest.getStudentCapacity(),
                userRequest.getCoursesOffered(),
                userRequest.getContactEmail(),
                userRequest.getContactPhone(),
                userRequest.getAddress(),
                userRequest.getCreatedOn()
                );
        return repository.save(user);


    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByCenterId(id);
        if(user!=null){
            return user;
        }
        else{
            throw new UserNotFoundException("user not found with id "+ id);
        }
    }



}

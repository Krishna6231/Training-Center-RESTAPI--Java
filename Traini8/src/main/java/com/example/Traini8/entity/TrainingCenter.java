package com.example.Traini8.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Traini8") // Specify the MongoDB collection name
public class TrainingCenter {

    @Id
    private String id;

    private String centerName;
    private String centerCode;
    private int studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;
    private Address address;

     // Populate with server timestamp
    private long createdOn;

    public TrainingCenter(String centerName, String centerCode, int studentCapacity, List<String> coursesOffered,
                          String contactEmail, String contactPhone, Address address, long createdOn) {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.studentCapacity = studentCapacity;
        this.coursesOffered = coursesOffered;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.address = address;
        this.createdOn= createdOn;
    }

}

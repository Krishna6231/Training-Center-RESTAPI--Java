package com.example.Traini8.dto;

import com.example.Traini8.entity.Address;
import jakarta.persistence.Embedded;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    private String centerName;
    private String centerCode;
//    private Address address;
    private int studentCapacity;
    private List<String> coursesOffered;
    @Email(message="invalid email address")
    private String contactEmail;
    @Pattern(regexp = "^\\d{10}$", message= "invalid mobile number")
    private String contactPhone;


    @Embedded
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
}

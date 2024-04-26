package com.example.Traini8.dto;

import com.example.Traini8.entity.Address;
import com.example.Traini8.validation.ValidCenterCode;
import com.example.Traini8.validation.ValidCenterName;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Center Name is required")
    @ValidCenterName
    private String centerName;

    @NotBlank(message = "Center Code is required")
    @ValidCenterCode
    private String centerCode;
    private int studentCapacity;
    private List<String> coursesOffered;
    @Email(message = "invalid email address")
    private String contactEmail;
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String contactPhone;

    @Field("address") // Specified the field name for MongoDB mapping
    private Address address;

    private long createdOn;
}

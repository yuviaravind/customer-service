package com.learn.customer_service.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document(collection = "customer_details")
public class Customer {
    @Id
    private Long customerId;
    @NotBlank(message = "Customer name should not be blank")
    private String customerName;
    @NotBlank(message = "Customer mobile number should not be blank")
    private String mobileNumber;
    private String email;
    private String address;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    private boolean isDeleted;
}

package com.jrbrayjr.spring.cloud.streams.streamfunction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
}

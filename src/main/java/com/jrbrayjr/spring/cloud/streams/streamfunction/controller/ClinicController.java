package com.jrbrayjr.spring.cloud.streams.streamfunction.controller;

import com.jrbrayjr.spring.cloud.streams.streamfunction.events.ClinicEventEmitter;
import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import com.jrbrayjr.spring.cloud.streams.streamfunction.service.PatientService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.metadata.aggregated.rule.OverridingMethodMustNotAlterParameterConstraints;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class ClinicController {


    private PatientService patientService;

    public ClinicController(PatientService patientService) {

        this.patientService = patientService;
    }

    @PostMapping( value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerNewPatient(@RequestBody Patient patient) {
        URI patientUri = null;
        try {
            patientUri = new URI("/register");
        } catch(URISyntaxException urise) {
            // some logging here
            return ResponseEntity.badRequest().build();
        }
        ResponseEntity<Void> responseEntity = ResponseEntity.created(patientUri).contentType(MediaType.APPLICATION_JSON).build();
        return responseEntity;
    }
}

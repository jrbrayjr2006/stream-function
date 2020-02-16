package com.jrbrayjr.spring.cloud.streams.streamfunction.events;

import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Function;
import java.util.function.Supplier;

@Controller
public class ClinicEventEmitter {

    private EmitterProcessor<Patient> patientEmitterProcessor = EmitterProcessor.create();


    @PostMapping( value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody Patient patient) {
        patientEmitterProcessor.onNext(patient);
    }

    @Bean
    public Supplier<Flux<Patient>> emitRegistrationSupplier(Patient patient) {
        return () -> patientEmitterProcessor;
    }

}

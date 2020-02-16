package com.jrbrayjr.spring.cloud.streams.streamfunction.events;

import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient) throws URISyntaxException {
        patientEmitterProcessor.onNext(patient);
        URI uri = new URI("/register");
        return ResponseEntity.created(uri).build();
    }

    @Bean
    public Function<String, String> emitHealthTips() {
        return value -> "No smoking!";
    }

    @Bean
    public Supplier<Flux<Patient>> emitRegistrationSupplier(Patient patient) {
        return () -> patientEmitterProcessor;
    }

    public EmitterProcessor<Patient> getPatientEmitterProcessor() {
        return patientEmitterProcessor;
    }
}

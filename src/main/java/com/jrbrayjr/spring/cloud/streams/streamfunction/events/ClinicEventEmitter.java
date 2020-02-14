package com.jrbrayjr.spring.cloud.streams.streamfunction.events;

import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class ClinicEventEmitter {

    private EmitterProcessor<Patient> patientEmitterProcessor = EmitterProcessor.create();

    @Bean
    public Function<String, String> emitHealthTips() {
        return value -> "No smoking!";
    }

    @Bean
    public Supplier<Flux<Patient>> emitRegistration() {
        return () -> patientEmitterProcessor;
    }

    public EmitterProcessor<Patient> getPatientEmitterProcessor() {
        return patientEmitterProcessor;
    }
}

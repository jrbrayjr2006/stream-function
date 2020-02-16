package com.jrbrayjr.spring.cloud.streams.streamfunction.controller;

import com.jrbrayjr.spring.cloud.streams.streamfunction.events.ClinicEventEmitter;
import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import com.jrbrayjr.spring.cloud.streams.streamfunction.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest( controllers = {ClinicController.class})
class ClinicControllerTest {
    @MockBean
    PatientService mockPatientService;

    @Autowired
    ClinicController controller;

    @Autowired
    WebTestClient webClient;

    @BeforeEach
    void setUp() {
        controller = new ClinicController(mockPatientService);
        webClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    @DisplayName("Given a patient, when the patient data is posted, then the status should return created")
    void shouldHaveStatusCreated() {
        // Given
        Patient patient = new Patient();
        String endpoint = "/create";

        // When
        webClient.post().uri(endpoint).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(patient)).exchange().expectStatus().isCreated();

        // Then
    }

}
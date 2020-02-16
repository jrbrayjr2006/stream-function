package com.jrbrayjr.spring.cloud.streams.streamfunction.service;

import com.jrbrayjr.spring.cloud.streams.streamfunction.events.ClinicEventEmitter;
import com.jrbrayjr.spring.cloud.streams.streamfunction.model.Patient;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class PatientService {


    public Object registerPatient(Patient patient) {
        return null;
    }
}

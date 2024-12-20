package com.me.hospital_management;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientHeap patientHeap;

    public PatientController() {
        patientHeap = new PatientHeap(); 
    }
    @GetMapping("/processed")
    public List<Patient> getProcessedPatients() {
        return patientHeap.processPatientsWithLimit();
    }

    @GetMapping("/sorted")
    public List<Patient> getSortedPatients() {
        getProcessedPatients();
        return patientHeap.getSortedPatients();
    }

    

   

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientHeap.insert(patient);

        System.out.println("New patient added to heap: " + patient);

        return ResponseEntity.ok("Patient added successfully");
    }

    @PostMapping("/batch")
    public ResponseEntity<String> addPatientsBatch(@RequestBody List<Patient> patients) {
        for (Patient patient : patients) {
            patientHeap.insert(patient);
            System.out.println("Batch added patient: " + patient);
        }

        return ResponseEntity.ok("Patients added successfully");
    }

}

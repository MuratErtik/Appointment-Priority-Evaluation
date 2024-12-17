package com.me.hospital_management;

import java.util.Objects;

public class Patient {

    private int patientID; // special id, one of each patient has this id
    private int priorityLevel; // from 10 to 1. 1 is most emergency situation
    private int appointmentDuration; // every single patient has a time

    public Patient() {}

    public Patient(int pID, int prLevel, int aD) {
        this.patientID = pID;
        this.priorityLevel = prLevel;
        this.appointmentDuration = aD;
    }

    public int getId() {
        return patientID;
    }

    public int getPriority() {
        return priorityLevel;
    }

    public int getAppointmentTime() {
        return appointmentDuration;
    }

    public void setId(int id) {
        this.patientID = id;
    }

    public void setPriority(int priority) {
        this.priorityLevel = priority;
    }

    public void setAppointmentTime(int time) {
        this.appointmentDuration = time;
    }

    @Override
    public String toString() {
        return "Patient[ID=" + getId() + ", Priority=" + getPriority() + ", Treatment Time=" + getAppointmentTime() + " mins]";
    }

    // Override equals() and hashCode() to ensure that Patients with the same ID are considered equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return patientID == patient.patientID; // Patients are equal if their IDs match
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientID); // Use patientID for hashCode
    }
}

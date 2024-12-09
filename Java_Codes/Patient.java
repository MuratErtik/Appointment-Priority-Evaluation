package Java_Codes;

public class Patient {

    private int patientID; // special id, one of each patient has this id

    private int priorityLevel; // from 10 to 1. 1 is most emergency situation

    private int appointmentDuration; // every single patient has a time 

    
    public Patient(int pID,int prLevel,int aD){

        this.patientID=pID;
        this.priorityLevel=prLevel;
        this.appointmentDuration=aD;

    }

   
    public int getId() {
        return patientID;
    }

    public int getPriority() {
        return priorityLevel;
    }

    public int getTreatmentTime() {
        return appointmentDuration;
    }



    
    
}

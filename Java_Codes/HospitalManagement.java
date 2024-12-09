package Java_Codes;

import java.util.Scanner;

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientHeap heap = new PatientHeap();

        while (true) {
            System.out.println("\n--- Hospital Management Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient (Highest Priority)");
            System.out.println("3. Display Patients (Sorted by Priority)");
            System.out.println("4. View Removed Patients");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner, heap);
                    break;
                case 2:
                    removePatient(heap); // Remove highest priority patient (root)
                    break;
                case 3:
                    System.out.println("\nPatients in Priority Order:");
                    heap.printLevelOrder(); // Print patients level by level
                    break;
                case 4:
                    System.out.println("\n--- Removed Patients ---");
                    for (Patient patient : heap.getRemovedPatients()) {
                        System.out.println(patient);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addPatient(Scanner scanner, PatientHeap heap) {
        System.out.println("\n--- Add Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Priority (1-10, where 1 is most urgent): ");
        int priority = scanner.nextInt();

        System.out.print("Enter Treatment Time (in minutes): ");
        int treatmentTime = scanner.nextInt();

        // Create a Patient object and set its properties
        Patient patient = new Patient();
        patient.setId(id);
        patient.setPriority(priority);
        patient.setAppointmentTime(treatmentTime);

        // Add the patient to the heap
        heap.insert(patient); // Now passing the full Patient object

        System.out.println("Patient added successfully!");
    }

    private static void removePatient(PatientHeap heap) {
        System.out.println("\n--- Remove Patient (Highest Priority) ---");

        // Remove the patient (highest priority) from the heap
        heap.removeRoot();

        System.out.println("Highest priority patient removed successfully!");
    }
}

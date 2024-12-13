package Java_Codes;

import java.util.Scanner;

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientHeap heap = new PatientHeap();

        while (true) {
            System.out.println("\n--- Hospital Management Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients (Sorted by Priority)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner, heap);
                    break;
                case 2:
                    System.out.println("\nPatients in Priority Order:");
                    heap.printLevelOrder();
                    break;
                case 3:
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

        Patient patient = new Patient();
        patient.setId(id);
        patient.setPriority(priority);
        patient.setAppointmentTime(treatmentTime);

        heap.insert(patient);

        System.out.println("Patient added successfully!");
    }
}

# Appointment-Priority-Evaluation-with-Min-Heap
I have created this repository for the Analysis and Complexity of Algorithm lecture's project. The main goal of the project is  implementation Min-Heap data structure and execute in the real life execution. So for this goal I will use Java and HTML/CSS.

Web tasarimi 
# Hospital Management System

## Overview
The **Hospital Management System** is designed to streamline patient management by leveraging a **Min-Heap** data structure. This system allows hospitals to prioritize patients based on their priority levels, manage treatment times, and keep track of processed patients efficiently. The system includes a web-based frontend and a backend implemented in **Java (Spring Boot)**.

---

## Features

### Frontend Features

The frontend provides a user-friendly interface for managing patients and includes the following functionalities:

1. **Add Patient**:
   - Form to manually add patient details such as ID, priority (1-10), and treatment time.
   - Option to upload a `.txt` file with patient details for batch processing.

2. **View Patients**:
   - Display all patients currently in the heap.
   - Show processed and sorted patients based on their priorities.

3. **Responsive Design**:
   - Adapts to various devices for seamless user experience.

---

### Backend Features

The backend is implemented in Java using Spring Boot and provides several REST APIs to interact with the patient management system. It uses a **Min-Heap** to manage patient data efficiently.

#### PatientController

The **PatientController** handles all RESTful endpoints for the system. Key endpoints include:

- **`GET /api/patients/processed`**:
  - Retrieves a list of patients processed within the maximum treatment time limit (420 minutes).

- **`GET /api/patients/sorted`**:
  - Returns patients sorted by priority after processing.


- **`POST /api/patients`**:
  - Adds a single patient to the heap.

- **`POST /api/patients/batch`**:
  - Adds multiple patients to the heap in a batch.

---

#### PatientHeap

The **PatientHeap** class is the core of the system. It uses a Min-Heap data structure to manage patients based on their priority levels. Key operations include:

- **Insert**:
  - Adds a patient to the heap and maintains heap property.

- **Remove Root**:
  - Removes the patient with the highest priority (minimum priority value).

- **Process Patients**:
  - Processes patients until the total treatment time reaches the maximum limit (420 minutes).

- **Get All Patients**:
  - Retrieves all patients in the heap using level-order traversal.

- **Initialize Default Patients**:
  - Populates the heap with a predefined set of patients for testing and demonstration.

---

### Key Classes

1. **Patient**:
   - Represents a patient with attributes: `id`, `priority`, and `appointmentTime`.

2. **PatientHeap**:
   - Implements the Min-Heap data structure for efficient patient management.

3. **PatientController**:
   - Manages RESTful API requests and interacts with the PatientHeap.

---



## Usage

### Adding a Patient
- Navigate to the "Add Patient" section.
- Fill in the patient details or upload a `.txt` file.
- Submit the form to add patients to the heap.

### Viewing Patients
- Click the "View Patients" button to see the list of patients in the heap.
- Use the API endpoints for processed or sorted patients.

---

## Technologies Used

1. **Frontend**:
   - HTML5, CSS3, JavaScript

2. **Backend**:
   - Java, Spring Boot
   - Min-Heap implementation for efficient data management

3. **Build Tools**:
   - Maven

---




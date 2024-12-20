document.getElementById('viewPatientsButton').addEventListener('click', function () {
    let textContent = 'PATIENTS(have not appointment)\n\n'; 

    fetch('http://localhost:8080/api/patients/sorted')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(sortedData => {
            sortedData.forEach(patient => {
                const treatmentTime = patient.appointmentTime !== undefined ? patient.appointmentTime : 'undefined';
                textContent += `ID: ${patient.id}, Priority: ${patient.priority}, Treatment Time: ${treatmentTime} mins\n`;
            });

            textContent += '\nPATIENTS(have appointment)\n\n'; 

            return fetch('http://localhost:8080/api/patients/processed');
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(processedData => {
            processedData.forEach(patient => {
                const treatmentTime = patient.appointmentTime !== undefined ? patient.appointmentTime : 'undefined';
                textContent += `ID: ${patient.id}, Priority: ${patient.priority}, Treatment Time: ${treatmentTime} mins\n`;
            });

            const blob = new Blob([textContent], { type: 'text/plain' });
            const link = document.createElement('a');
            link.href = URL.createObjectURL(blob);
            link.download = 'patients.txt'; 
            link.click();
        })
        .catch(error => {
            console.error('Error fetching patients:', error);
            alert('An error occurred while fetching patients.');
        });
});




document.getElementById('patientForm').addEventListener('submit', function (e) {
e.preventDefault();

const id = document.getElementById('id').value;
const priority = document.getElementById('priority').value;
const time = document.getElementById('time').value;

const patientData = {
    id: parseInt(id, 10),
    priority: parseInt(priority, 10),
    appointmentTime: parseInt(time, 10)
};

fetch('http://localhost:8080/api/patients', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(patientData),
})
    .then(response => {
        
        if (response.status === 201 || response.status === 200) {
            return response.json(); 
        } else {
            throw new Error(`Unexpected response: ${response.status}`);
        }
    })
    .then(data => {
        console.log('Patient added successfully:', data);
        alert('Patient added successfully!');
    })
    .catch(error => {
        console.error('Error adding patient:', error);
        alert('Patient added successfully!');
    });
});

function showAddPatientForm() {
document.getElementById('add-patient-form').classList.remove('hidden');
}

function hideAddPatientForm() {
document.getElementById('add-patient-form').classList.add('hidden');
}
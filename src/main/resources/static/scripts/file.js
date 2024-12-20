function uploadPatientFile() {
    const fileInput = document.getElementById('patientFile');
    const file = fileInput.files[0];

    if (!file) {
        alert('Please select a file to upload.');
        return;
    }

    const reader = new FileReader();

    reader.onload = function (e) {
        const fileContent = e.target.result;

        const patients = [];
        const lines = fileContent.split('\n');

        lines.forEach(line => {
            const [id, priority, time] = line.split(',').map(value => value.trim());
            if (id && priority && time) {
                patients.push({
                    id: parseInt(id, 10),
                    priority: parseInt(priority, 10),
                    appointmentTime: parseInt(time, 10),
                });
            }
        });

        if (patients.length > 0) {
            fetch('http://localhost:8080/api/patients/batch', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(patients),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Patients added successfully!');
                    } else {
                        throw new Error('Failed to add patients.');
                    }
                })
                .catch(error => {
                    console.error('Error adding patients:', error);
                    alert('An error occurred while adding patients.');
                });
        } else {
            alert('No valid patient data found in the file.');
        }
    };

    reader.onerror = function () {
        alert('Failed to read file.');
    };

    reader.readAsText(file); 
}
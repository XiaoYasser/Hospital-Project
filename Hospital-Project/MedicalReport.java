package Hospital_Abdallah;

public class MedicalReport{
	
	private int medicalRecordNumber;
    private boolean medication;
    private String medicationDescription;
    private String allergy;
    private String problem;
    private String cause;
    private String diagnosis;

    public MedicalReport(int medicalRecordNumber, boolean medication, String medicationDescription,
                         String allergy, String problem, String cause, String diagnosis) {
    	
        if (medicalRecordNumber <=0 ) {
            throw new IllegalArgumentException("Medical record number cannot be 0 or negative.");
        }
        if (problem == null || problem.trim().isEmpty()) {
            throw new IllegalArgumentException("Problem cannot be null or empty.");
        }
        if (cause == null || cause.trim().isEmpty()) {
            throw new IllegalArgumentException("Cause cannot be null or empty.");
        }
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnosis cannot be null or empty.");
        }
        if (medication && (medicationDescription == null || medicationDescription.trim().isEmpty())) {
            throw new IllegalArgumentException("Medication description cannot be null or empty if medication is required.");
        }

        this.medicalRecordNumber = medicalRecordNumber;
        this.medication = medication;
        this.medicationDescription = medication ? medicationDescription : "";
        this.allergy = allergy != null && !allergy.trim().isEmpty() ? allergy : "No allergy";
        this.problem = problem;
        this.cause = cause;
        this.diagnosis = diagnosis;
    }

    public int getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(int medicalRecordNumber) {
        if (medicalRecordNumber <= 0) {
            throw new IllegalArgumentException("Medical record number cannot be null or empty.");
        }
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public boolean isMedication() {
        return medication;
    }

    public void setMedication(boolean medication) {
        this.medication = medication;
        if (!medication) {
            this.medicationDescription = "";
        }
    }

    public String getMedicationDescription() {
        return medicationDescription;
    }

    public void setMedicationDescription(String medicationDescription) {
        if (medication && (medicationDescription == null || medicationDescription.trim().isEmpty())) {
            throw new IllegalArgumentException("Medication description cannot be null or empty if medication is required.");
        }
        this.medicationDescription = medicationDescription;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy != null && !allergy.trim().isEmpty() ? allergy : "No allergy";
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        if (problem == null || problem.trim().isEmpty()) {
            throw new IllegalArgumentException("Problem cannot be null or empty.");
        }
        this.problem = problem;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        if (cause == null || cause.trim().isEmpty()) {
            throw new IllegalArgumentException("Cause cannot be null or empty.");
        }
        this.cause = cause;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnosis cannot be null or empty.");
        }
        this.diagnosis = diagnosis;
    }
	
}

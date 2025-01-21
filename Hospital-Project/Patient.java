package Hospital_Abdallah;
import java.util.List;
import java.util.ArrayList;

public class Patient extends Person implements Searchable<Patient> {
	
	private long nationalID;
    private String medicalHistory;
    private long emergencyPhone;
    private int patientID;

    private Doctor doctor;
    private Nurse nurse;
    private Guardian guardian;
    private MedicalReport medicalReport;
    private Prescription prescription;

    public Patient() {
        super();
        this.patientID = 0;
        this.medicalHistory = "";
        this.emergencyPhone = 0;
        this.nationalID = 0;
    }

    public Patient(String name, int age, Gender gender) { //3shan el Medical Report
        super(name, age, gender);
    }

    public Patient(String name, int age, Gender gender, String address, String email, long phone, 
                   long nationalID, String medicalHistory, long emergencyPhone, int patientID,
                   Doctor doctor, Nurse nurse) {
        super(name, age, gender, address, email, phone);
        this.nationalID = nationalID;
        this.medicalHistory = medicalHistory;
        this.emergencyPhone = emergencyPhone;
        this.patientID = patientID;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public void displayReport() {
    	System.out.println("\n");
        System.out.println("=== Medical Report ===");
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + age);
        System.out.println("Medical Record Number: " + getMedicalReport().getMedicalRecordNumber());
        System.out.println("Allergy: " + getMedicalReport().getAllergy());
        System.out.println("Problem: " + getMedicalReport().getProblem());
        System.out.println("Cause: " + getMedicalReport().getCause());
        System.out.println("Diagnosis: " + getMedicalReport().getDiagnosis());
        if (getMedicalReport().isMedication()) {
            System.out.println("Medication Required: Yes");
            System.out.println("Medication Description: " + getMedicalReport().getMedicationDescription());
        } else {
            System.out.println("Medication Required: No");
        }
    }

    public long getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(long emergencyPhone) {
        if (String.valueOf(emergencyPhone).length() != 11) {
            throw new IllegalArgumentException("Invalid phone number. It must be 11 digits.");
        }
        this.emergencyPhone = emergencyPhone;
    }
    

    public void setMedicalReport(MedicalReport medicalReport) {
		this.medicalReport = medicalReport;
	}

	public MedicalReport getMedicalReport() {
        return medicalReport;
    }

    public long getNationalID() {
        return nationalID;
    }

    public void setNationalID(long nationalID) {
        this.nationalID = nationalID;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public void provideIdentification() {
        System.out.println("Patient ID: " + patientID + ", Name: " + getName());
    }

    @Override
    public List<Patient> search(int criteria) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : Person.getPatients()) {
            if (patient.getPatientID() == criteria) {
                result.add(patient);
            }
        }
        return result;
    }
    
}


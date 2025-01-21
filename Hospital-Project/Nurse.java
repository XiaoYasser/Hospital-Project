package Hospital_Abdallah;

import java.time.LocalDate;

public class Nurse extends Employee {
	
	private String specialization;
    private String clinicalSkills;
    private String medicalProcedures;
    private String careExperience;
    private String certificate;
    private int patientLoad;
    private String medLicenseNumber;

    public Nurse() {
        super();
        this.specialization = "";
        this.clinicalSkills = "";
        this.medicalProcedures = "";
        this.careExperience = "";
        this.certificate = "";
        this.patientLoad = 0;
        this.medLicenseNumber = "";
    }

    public Nurse(int employeeID, String name, int age, Gender gender, String address, String email, long phone,
                 String position, LocalDate dateOfHire, double salary, String shift, String employmentStatus,
                 String specialization, String clinicalSkills, String medicalProcedures, String careExperience,
                 String certificate, int patientLoad, String medLicenseNumber) {
        super(employeeID, name, age, gender, address, email, phone, position, dateOfHire, salary, shift, employmentStatus);
        this.specialization = specialization;
        this.clinicalSkills = clinicalSkills;
        this.medicalProcedures = medicalProcedures;
        this.careExperience = careExperience;
        this.certificate = certificate;
        this.patientLoad = patientLoad; // Ensures patientLoad is non-negative
        this.medLicenseNumber = medLicenseNumber;

    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
        this.specialization = specialization;
    }

    public String getClinicalSkills() {
        return clinicalSkills;
    }

    public void setClinicalSkills(String clinicalSkills) {
        this.clinicalSkills = clinicalSkills;
    }

    public String getMedicalProcedures() {
        return medicalProcedures;
    }

    public void setMedicalProcedures(String medicalProcedures) {
        this.medicalProcedures = medicalProcedures;
    }

    public String getCareExperience() {
        return careExperience;
    }

    public void setCareExperience(String careExperience) {
        this.careExperience = careExperience;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getPatientLoad() {
        return patientLoad;
    }

    public void setPatientLoad(int patientLoad) {
        if (patientLoad < 0) {
            throw new IllegalArgumentException("Patient load cannot be negative.");
        }
        this.patientLoad = patientLoad;
    }

    public String getMedLicenseNumber() {
        return medLicenseNumber;
    }

    public void setMedLicenseNumber(String medLicenseNumber) {
        this.medLicenseNumber = medLicenseNumber;
    }

   

    public void administerMedication(Patient patient, Prescription prescription) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null.");
        }
        System.out.println("Administering medication to patient: " + patient.getName());
        System.out.println("Medication: " + prescription.getMedication());
        System.out.println("Dosage: " + prescription.getDosage());
        System.out.println("Instructions: " + prescription.getInstructions());
    }

    @Override
    public void checkIn() {
        System.out.println("Nurse " + getName() + " is checking in.");
    }

    @Override
    public void provideIdentification() {
        System.out.println("Nurse ID: " + getEmployeeID() + ", Name: " + getName());
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Nurse " + getName() + " received notification: " + message);
    }

    @Override
    public String toString() {
        return "Nurse [Specialization=" + specialization + ", Clinical Skills=" + clinicalSkills +
                ", Medical Procedures=" + medicalProcedures + ", Care Experience=" + careExperience +
                ", Certificate=" + certificate + ", Patient Load=" + patientLoad + ", Medical License Number=" +
                medLicenseNumber + "]";
    }

    
	
	
	

}

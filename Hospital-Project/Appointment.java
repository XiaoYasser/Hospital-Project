package Hospital_Abdallah;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment{

	private static ArrayList<Appointment> appointments = new ArrayList<>();

    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String appointmentDescription;

    public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime, String appointmentDescription) {
    	if (!(patient instanceof Patient)) {
            throw new IllegalArgumentException("Invalid data type: patient must be of type Patient.");
        }
        if (!(doctor instanceof Doctor)) {
            throw new IllegalArgumentException("Invalid data type: doctor must be of type Doctor.");
        }
        if (!(appointmentDate instanceof LocalDate)) {
            throw new IllegalArgumentException("Invalid data type: appointmentDate must be of type LocalDate.");
        }
        if (!(appointmentTime instanceof LocalTime)) {
            throw new IllegalArgumentException("Invalid data type: appointmentTime must be of type LocalTime.");
        }
        if (!(appointmentDescription instanceof String) || ((String) appointmentDescription).trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid data type: appointmentDescription must be a non-empty String.");
        }
        
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentDescription = appointmentDescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (!(patient instanceof Patient) || patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        if (!(doctor instanceof Doctor) || doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }
        this.doctor = doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if (!(appointmentDate instanceof LocalDate) || appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        if (!(appointmentTime instanceof LocalTime) ||appointmentTime == null) {
            throw new IllegalArgumentException("Appointment time cannot be null.");
        }
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if (!(appointmentDescription instanceof String) || appointmentDescription == null || appointmentDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment description cannot be null or empty.");
        }
        this.appointmentDescription = appointmentDescription;
    }

    public void displayAppointment() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patient.getName() + ", ID: " + patient.getPatientID());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Description: " + appointmentDescription);
    }

    public static void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        appointments.add(appointment);
        System.out.println("Appointment added successfully.");
    }

    public static List<Appointment> search(int patientID) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getPatientID() == patientID) {
                result.add(appointment);
            }
        }
        return result;
    }

    
    public static void removeAppointment(int patientID) {
        List<Appointment> foundAppointments = search(patientID);
        if (!foundAppointments.isEmpty()) {
            appointments.removeAll(foundAppointments);
            System.out.println("Appointment(s) removed for Patient ID: " + patientID);
        } else {
            System.out.println("No appointment found for Patient ID: " + patientID);
        }
    }



    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}

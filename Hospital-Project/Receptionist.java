package Hospital_Abdallah;

import java.time.LocalDate;
import java.time.LocalTime;


public class Receptionist extends Employee {

    public Receptionist(int employeeID, String name, byte age, Gender gender, String address, String email, long phone,
                        String position, LocalDate dateOfHire, double salary, String shift, String employmentStatus) {
        super(employeeID, name, age, gender, address, email, phone, position, dateOfHire, salary, shift, employmentStatus);
    }

    public void scheduleAppointment(Patient patient, Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime, String appointmentDescription) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null.");
        }
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        if (appointmentTime == null) {
            throw new IllegalArgumentException("Appointment time cannot be null.");
        }
        if (appointmentDescription == null || appointmentDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment description cannot be null or empty.");
        }
        if (appointmentDate.isBefore(LocalDate.now())) {
            System.out.println("Error: Appointment date cannot be in the past.");
            return;
        }

        Appointment appointment = new Appointment(patient, doctor, appointmentDate, appointmentTime, appointmentDescription);
        Appointment.addAppointment(appointment);
        System.out.println("Appointment scheduled successfully for patient " + patient.getName() +
                           " with doctor " + doctor.getName() + " on " + appointmentDate + " at " + appointmentTime + ".");
    }

    public void removeAppointment(int patientID) {
        if (patientID <= 0) {
            throw new IllegalArgumentException("Patient ID must be a positive integer.");
        }
        Appointment.removeAppointment(patientID);
    }

    public void viewAllAppointments() {
        if (Appointment.getAppointments().size() == 0) {
            System.out.println("No appointments scheduled.");
            return;
        }
        
        System.out.println("All Appointments:");
        for (int i = 0; i < Appointment.getAppointments().size(); i++) {
            Appointment appointment = Appointment.getAppointments().get(i);
            System.out.println(appointment.toString());
        }
    }

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void provideIdentification() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveNotification(String message) {
		// TODO Auto-generated method stub
		
	}

}

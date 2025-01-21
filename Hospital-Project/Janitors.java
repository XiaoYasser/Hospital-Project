package Hospital_Abdallah;

import java.time.LocalDate;

public class Janitors extends Employee {

	private String assignedArea;
    private String cleaningEquipmentProficiency;

    public Janitors() {
        super();
        this.assignedArea = "General";
        this.cleaningEquipmentProficiency = "Basic";
    }

    public Janitors(int employeeID, String name, int age, Gender gender, String address, String email, long phone,
                    String position, LocalDate dateOfHire, double salary, String shift, String employmentStatus,
                    String assignedArea, String cleaningEquipmentProficiency) {
        super(employeeID, name, age, gender, address, email, phone, position, dateOfHire, salary, shift, employmentStatus);
        if (assignedArea == null || assignedArea.trim().isEmpty()) {
            throw new IllegalArgumentException("Assigned area cannot be null or empty.");
        }
        if (cleaningEquipmentProficiency == null || cleaningEquipmentProficiency.trim().isEmpty()) {
            throw new IllegalArgumentException("Cleaning equipment proficiency cannot be null or empty.");
        }
        this.assignedArea = assignedArea;
        this.cleaningEquipmentProficiency = cleaningEquipmentProficiency;
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        if (assignedArea == null || assignedArea.trim().isEmpty()) {
            throw new IllegalArgumentException("Assigned area cannot be null or empty.");
        }
        this.assignedArea = assignedArea;
    }

    public String getCleaningEquipmentProficiency() {
        return cleaningEquipmentProficiency;
    }

    public void setCleaningEquipmentProficiency(String cleaningEquipmentProficiency) {
        if (cleaningEquipmentProficiency == null || cleaningEquipmentProficiency.trim().isEmpty()) {
            throw new IllegalArgumentException("Cleaning equipment proficiency cannot be null or empty.");
        }
        this.cleaningEquipmentProficiency = cleaningEquipmentProficiency;
    }

    @Override
    public void checkIn() {
        System.out.println("Janitor " + getName() + " has checked in for shift: " + getShift());
    }

    @Override
    public void provideIdentification() {
        System.out.println("Janitor ID: " + getEmployeeID() + ", Name: " + getName());
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Notification for Janitor " + getName() + ": " + message);
    }

    @Override
    public String toString() {
        return "Janitor [Assigned Area: " + assignedArea + 
                ", Cleaning Equipment Proficiency: " + cleaningEquipmentProficiency + 
                ", " + super.toString() + "]";
    }


}

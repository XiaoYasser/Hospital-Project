package Hospital_Abdallah;

import java.time.LocalDate;


public class Doctor extends Employee {

	private String specialization;
    private String experience;
    private Department department;

    public Doctor() {
        super();
        this.specialization = "General";
        this.experience = "0 years";
        this.department = null;
    }

    public Doctor(int employeeID, String name, int age, Gender gender, String address, String email, long phone,
                  String position, LocalDate dateOfHire, double salary, String shift, String employmentStatus,
                  String specialization, String experience, Department department) {
        super(employeeID, name, age, gender, address, email, phone, position, dateOfHire, salary, shift, employmentStatus);
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
        if (experience == null || experience.trim().isEmpty()) {
            throw new IllegalArgumentException("Experience cannot be null or empty.");
        }
        this.specialization = specialization;
        this.experience = experience;
        this.department = department;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        if (experience == null || experience.trim().isEmpty()) {
            throw new IllegalArgumentException("Experience cannot be null or empty.");
        }
        this.experience = experience;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public void checkIn() {
        System.out.println("Doctor " + getName() + " has checked in for shift: " + getShift());
    }

    @Override
    public void provideIdentification() {
        System.out.println("Doctor ID: " + getEmployeeID() + ", Name: " + getName());
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println("Doctor " + getName() + " received notification: " + message);
    }

    @Override
    public String toString() {
        return "Doctor [Specialization: " + specialization +
                ", Experience: " + experience +
                ", Department: " + (department != null ? department.getName() : "None") +
                ", " + super.toString() + "]";
    }
}

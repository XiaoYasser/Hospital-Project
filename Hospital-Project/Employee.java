package Hospital_Abdallah;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Searchable<Employee> {

    private int employeeID;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String email;
    private long phone;
    private String position;
    private LocalDate dateOfHire;
    private double salary;
    private String shift;
    private String employmentStatus;

    private static ArrayList<Employee> employees = new ArrayList<>();

    public Employee() {
        this.employeeID = 0;
        this.name = "";
        this.age = 0;
        this.gender = Gender.MALE; 
        this.address = "";
        this.email = "";
        this.phone = 0;
        this.position = "Employee";
        this.dateOfHire = LocalDate.now();
        this.salary = 0.0;
        this.shift = "";
        this.employmentStatus = "Active";
    }

    public Employee(int employeeID, String name, int age, Gender gender, String address, String email, long phone,
                    String position, LocalDate dateOfHire, double salary, String shift, String employmentStatus) {
        if (employeeID <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        if (email == null) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (String.valueOf(phone).length() != 11) {
            throw new IllegalArgumentException("Phone number must be 11 digits.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.dateOfHire = dateOfHire != null ? dateOfHire : LocalDate.now();
        this.salary = salary;
        this.shift = shift;
        this.employmentStatus = employmentStatus != null ? employmentStatus : "Active";
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        if (employeeID <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be valid.");
        }
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("The email cannot be null");
        }
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        if (String.valueOf(phone).length() != 11) {
            throw new IllegalArgumentException("Phone number must be 11 digits.");
        }
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty.");
        }
        this.position = position;
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        if (dateOfHire == null) {
            throw new IllegalArgumentException("Date of hire cannot be null.");
        }
        this.dateOfHire = dateOfHire;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        if (employmentStatus == null || employmentStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Employment status cannot be empty.");
        }
        this.employmentStatus = employmentStatus;
    }


    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        employees.add(employee);
    }
    
    public static void addEmployee(ArrayList<Employee> employee) {
        for(Employee e: employee) {
        	addEmployee(e);
        }
    }

    public static void removeEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        if (!employees.remove(employee)) {
            throw new IllegalArgumentException("Employee does not exist.");
        }
    }

    @Override
    public List<Employee> search(int criteria) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getEmployeeID() == criteria) {
                result.add(emp);
            }
        }
        return result;
    }

    // 3adel fe el ABSTRACT YA NATSU;
    public abstract void checkIn();

    public abstract void provideIdentification();

    public abstract void receiveNotification(String message);

    @Override
    public String toString() {
        return "Employee [ID: " + employeeID + ", Name: " + name + ", Age: " + age +
               ", Gender: " + gender + ", Position: " + position + 
               ", Date of Hire: " + dateOfHire + ", Salary: " + salary + "]";
    }
}

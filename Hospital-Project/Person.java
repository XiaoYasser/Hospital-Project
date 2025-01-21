package Hospital_Abdallah;

import java.util.ArrayList;


public abstract class Person{
	
	protected String name;
	protected int age;
	protected Gender gender;
	protected String address;
	protected String email;
	protected long phone;

    private static ArrayList<Patient> patients = new ArrayList<>();

    public Person() {
        this("test", 0, Gender.MALE, "", "", 0);
    }

    // Partial Constructor
    public Person(String name, int age, Gender gender) {
        this(name, age, gender, "", "", 0);
    }

    // Full Constructor
    public Person(String name, int age, Gender gender, String address, String email, long phone) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
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
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public abstract void provideIdentification();

    public static ArrayList<Patient> getPatients() {
        return Person.patients;
    }

    public static void addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Patient already exists.");
        }
    }

    public static void removePatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (patients.contains(patient)) {
            patients.remove(patient);
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient does not exist.");
        }
    }

	@Override
    public String toString() {
        return "Person [Name: " + name + ", Age: " + age + ", Gender: " + gender + 
               ", Address: " + address + ", Email: " + email + ", Phone: " + phone + "]";
    }

}

//package Hospital_Abdallah;
//
//import java.io.*; // 3shan el filat
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Scanner;
//
//public class TestMain {
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        boolean exit = false;
//
//        while (!exit) {
//            System.out.println("\n***** AAST Hospital Management System ****");
//            System.out.println("[1]. Add Patient");
//            System.out.println("[2]. Remove Patient");
//            System.out.println("[3]. Add Doctor");
//            System.out.println("[4]. Remove Doctor");
//            System.out.println("[5]. Schedule Appointment");
//            System.out.println("[6]. Remove Appointment");
//            System.out.println("[7]. Add Medical Report");
//            System.out.println("[8]. View All Patients");
//            System.out.println("[9]. View All Doctors");
//            System.out.println("[10]. View All Appointments");
//            System.out.println("[11]. Read Data from File");
//            System.out.println("[12]. Write Data to File");
//            System.out.println("[13]. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // de 3shan el enter b3d el choice
//
//            switch (choice) {
//                case 1:
//                    addPatient(scanner);
//                    break;
//                case 2:
//                    removePatient(scanner);
//                    break;
//                case 3:
//                    addDoctor(scanner);
//                    break;
//                case 4:
//                    removeDoctor(scanner);
//                    break;
//                case 5:
//                    scheduleAppointment(scanner);
//                    break;
//                case 6:
//                    removeAppointment(scanner);
//                    break;
//                case 7:
//                    addMedicalReport(scanner);
//                    break;
//                case 8:
//                    viewAllPatients();
//                    break;
//                case 9:
//                    viewAllDoctors();
//                    break;
//                case 10:
//                    viewAllAppointments();
//                    break;
//                case 11:
//                    readDataFromFile(scanner);
//                    break;
//                case 12:
//                    writeDataToFile(scanner);
//                    break;
//                case 13:
//                    System.out.println("Exiting system...");
//                    exit = true;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//    
//    private static void addPatient(Scanner scanner) {
//    	
//    	
//        System.out.print("Enter Patient Name: ");
//        String name = scanner.nextLine();
//        
//        System.out.print("Enter Age: ");
//        int age = scanner.nextInt();
//        scanner.nextLine(); 
//        System.out.print("Enter Gender: ");
//        String gender = scanner.nextLine();
//        System.out.print("Enter Address: ");
//        String address = scanner.nextLine();
//        System.out.print("Enter Email: ");
//        String email = scanner.nextLine();
//        System.out.print("Enter Phone: ");
//        long phone = scanner.nextLong();
//        scanner.nextLine();
//
//        Patient patient = new Patient(name, age, gender, address, email, phone, 0, "", 0, 0, null, null);
//        Person.addPatient(patient);
//        System.out.println("Patient added successfully!");
//    }
//
//    private static void removePatient(Scanner scanner) {
//        System.out.print("Enter Patient ID to remove: ");
//        int patientID = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < Person.getPatients().size(); i++) {
//            Patient patient = Person.getPatients().get(i);
//            if (patient.getPatientID() == patientID) {
//                Person.removePatient(patient);
//                System.out.println("Patient removed successfully!");
//                return;
//            }
//        }
//        System.out.println("Patient not found.");
//    }
//
//    private static void addDoctor(Scanner scanner) {
//        System.out.print("Enter Doctor Name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter Age: ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("Enter Gender: ");
//        String gender = scanner.nextLine();
//        System.out.print("Enter Specialization: ");
//        String specialization = scanner.nextLine();
//        System.out.print("Enter Experience: ");
//        String experience = scanner.nextLine();
//
//        Doctor doctor = new Doctor(0, name, (byte) age, gender, "", "", 0, "Doctor", LocalDate.now(), 0.0, "", "Active",
//                specialization, experience, null);
//        Employee.addEmployee(doctor);
//        System.out.println("Doctor added successfully!");
//    }
//
//    private static void removeDoctor(Scanner scanner) {
//        System.out.print("Enter Doctor ID to remove: ");
//        int doctorID = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < Employee.getEmployees().size(); i++) {
//            Employee emp = Employee.getEmployees().get(i);
//            if (emp instanceof Doctor && emp.getEmployeeID() == doctorID) {
//                Employee.removeEmployee(emp);
//                System.out.println("Doctor removed successfully!");
//                return;
//            }
//        }
//        System.out.println("Doctor not found.");
//    }
//
//    private static void scheduleAppointment(Scanner scanner) {
//        System.out.print("Enter Patient ID: ");
//        int patientID = scanner.nextInt();
//        scanner.nextLine();
//
//        Patient patient = null;
//        for (Patient p : Person.getPatients()) {
//            if (p.getPatientID() == patientID) {
//                patient = p;
//                break;
//            }
//        }
//
//        if (patient == null) {
//            System.out.println("Patient not found.");
//            return;
//        }
//
//        System.out.print("Enter Doctor ID: ");
//        int doctorID = scanner.nextInt();
//        scanner.nextLine();
//
//        Doctor doctor = null;
//        for (Employee emp : Employee.getEmployees()) {
//            if (emp instanceof Doctor && emp.getEmployeeID() == doctorID) {
//                doctor = (Doctor) emp;
//                break;
//            }
//        }
//
//        if (doctor == null) {
//            System.out.println("Doctor not found.");
//            return;
//        }
//
//        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
//        LocalDate date = LocalDate.parse(scanner.nextLine());
//        System.out.print("Enter Appointment Time (HH:MM): ");
//        LocalTime time = LocalTime.parse(scanner.nextLine());
//        System.out.print("Enter Appointment Description: ");
//        String description = scanner.nextLine();
//
//        Appointment appointment = new Appointment(patient, doctor, date, time, description);
//        Appointment.addAppointment(appointment);
//        System.out.println("Appointment scheduled successfully!");
//    }
//
//    private static void removeAppointment(Scanner scanner) {
//        System.out.print("Enter Patient ID to remove appointment: ");
//        int patientID = scanner.nextInt();
//        scanner.nextLine();
//
//        if (Appointment.removeAppointment(patientID)) {
//            System.out.println("Appointment removed successfully!");
//        } else {
//            System.out.println("No appointment found for Patient ID: " + patientID);
//        }
//    }
//
//    private static void addMedicalReport(Scanner scanner) {
//        System.out.print("Enter Patient ID: ");
//        int patientID = scanner.nextInt();
//        scanner.nextLine();
//
//        Patient patient = null;
//        for (Patient p : Person.getPatients()) {
//            if (p.getPatientID() == patientID) {
//                patient = p;
//                break;
//            }
//        }
//
//        if (patient == null) {
//            System.out.println("Patient not found.");
//            return;
//        }
//
//        System.out.print("Enter Medical Record Number: ");
//        String recordNumber = scanner.nextLine();
//        System.out.print("Has Medication? (true/false): ");
//        boolean medication = scanner.nextBoolean();
//        scanner.nextLine();
//        System.out.print("Enter Medication Description: ");
//        String medicationDescription = scanner.nextLine();
//        System.out.print("Enter Allergy: ");
//        String allergy = scanner.nextLine();
//        System.out.print("Enter Problem: ");
//        String problem = scanner.nextLine();
//        System.out.print("Enter Cause: ");
//        String cause = scanner.nextLine();
//        System.out.print("Enter Diagnosis: ");
//        String diagnosis = scanner.nextLine();
//
//        patient.generateMedicalReport(recordNumber, medication, medicationDescription, allergy, problem, cause, diagnosis);
//        System.out.println("Medical report added successfully!");
//    }
//
//    private static void viewAllPatients() {
//        for (int i = 0; i < Person.getPatients().size(); i++) {
//            System.out.println(Person.getPatients().get(i).toString());
//        }
//    }
//
//    private static void viewAllDoctors() {
//        for (int i = 0; i < Employee.getEmployees().size(); i++) {
//            Employee emp = Employee.getEmployees().get(i);
//            if (emp instanceof Doctor) {
//                System.out.println(emp.toString());
//            }
//        }
//    }
//
//    private static void viewAllAppointments() {
//        for (int i = 0; i < Appointment.getAppointments().size(); i++) {
//            Appointment.getAppointments().get(i).displayAppointment();
//        }
//    }
//
//    private static void readDataFromFile(Scanner scanner) throws IOException {
//        System.out.print("Enter the file name to read data: ");
//        String fileName = scanner.nextLine();
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//        reader.close();
//    }
//
//    private static void writeDataToFile(Scanner scanner) throws IOException {
//        System.out.print("Enter the file name to save data: ");
//        String fileName = scanner.nextLine();
//        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//
//        writer.write("=== Patients ===\n");
//        for (int i = 0; i < Person.getPatients().size(); i++) {
//            writer.write(Person.getPatients().get(i).toString() + "\n");
//        }
//
//        writer.write("\n=== Doctors ===\n");
//        for (int i = 0; i < Employee.getEmployees().size(); i++) {
//            Employee emp = Employee.getEmployees().get(i);
//            if (emp instanceof Doctor) {
//                writer.write(emp.toString() + "\n");
//            }
//        }
//
//        writer.write("\n=== Appointments ===\n");
//        for (int i = 0; i < Appointment.getAppointments().size(); i++) {
//            writer.write(Appointment.getAppointments().get(i).toString() + "\n");
//        }
//
//        writer.close();
//        System.out.println("Data saved successfully!");
//    }
//}

package Hospital_Abdallah;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Department emergency = new Department("Emergency", 1, "Building A", null); 
        Department neurology = new Department("Neurology", 2, "Building B", null); 
        Department operations = new Department("Operations", 3, "Building C", null); 
        Department clinics = new Department("Clinics", 4, "Building D", null); 
        Department radiology = new Department("Radiology", 5, "Building E", null);
        
        Employee doctor1 = new Doctor(1, "Dr. Hassan Ali", 45, Gender.MALE, "123 Street, Cairo", "hassan.ali@example.com", 12345678901L, "Senior Doctor", LocalDate.of(2005, 1, 15), 80000, "Day", "Full-time", "Cardiology", "20 years", emergency);
        Employee doctor2 = new Doctor(2, "Dr. Samira Younis", 38, Gender.FEMALE, "456 Avenue, Cairo", "samira.younis@example.com", 23456789012L, "Doctor", LocalDate.of(2010, 3, 20), 60000, "Night", "Full-time", "Neurology", "15 years", neurology); 
        Employee doctor3 = new Doctor(3, "Dr. Yasser Mohamed", 50, Gender.MALE, "789 Boulevard, Cairo", "yasser.mohamed@example.com", 34567890123L, "Consultant", LocalDate.of(2000, 5, 25), 90000, "Day", "Full-time", "Oncology", "25 years", operations); 
        Employee doctor4 = new Doctor(4, "Dr. Alya Badawi", 42, Gender.FEMALE, "101 Road, Cairo", "alya.badawi@example.com", 45678901230L, "Doctor", LocalDate.of(2012, 7, 30), 65000, "Night", "Full-time", "Pediatrics", "18 years", radiology); 
        Employee doctor5 = new Doctor(5, "Dr. Khaled Gaber", 35, Gender.MALE, "202 Lane, Cairo", "khaled.gaber@example.com", 56789012341L, "Junior Doctor", LocalDate.of(2015, 9, 10), 50000, "Day", "Full-time", "Radiology", "10 years",clinics);
        
        emergency.setHeadofDep((Doctor)doctor1);
        clinics.setHeadofDep((Doctor)doctor2);
        operations.setHeadofDep((Doctor)doctor3);
        clinics.setHeadofDep((Doctor)doctor4);
        radiology.setHeadofDep((Doctor)doctor5);
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\n***** AAST Hospital Management System ****");
            System.out.println("[1]. Add Patient");
            System.out.println("[2]. Remove Patient");
            System.out.println("[3]. Add Doctor");
            System.out.println("[4]. Remove Doctor");
            System.out.println("[5]. Schedule Appointment");
            System.out.println("[6]. Remove Appointment");
            System.out.println("[7]. Set Prescription");
            System.out.println("[8]. Add Medical Report");
            System.out.println("[9]. Display Medical Report");
            System.out.println("[10]. View All Patients");
            System.out.println("[11]. View All Doctors");
            System.out.println("[12]. View All Appointments");
            System.out.println("[13]. Read Data from File");
            System.out.println("[14]. Write Data to File");
            System.out.println("[15]. Append Data to File");
            System.out.println("[16]. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    removePatient(scanner);
                    break;
                case 3:
                    addDoctor(scanner);
                    break;
                case 4:
                    removeDoctor(scanner);
                    break;
                case 5:
                    scheduleAppointment(scanner);
                    break;
                case 6:
                    removeAppointment(scanner);
                    break;
                case 7:
                    setPrescription(scanner);
                    break;
                case 8:
                    addMedicalReport(scanner);
                    break;
                case 9:
                    displayMedicalReport(scanner);
                    break;
                case 10:
                    viewAllPatients();
                    break;
                case 11:
                    viewAllDoctors();
                    break;
                case 12:
                    viewAllAppointments();
                    break;
                case 13:
                    readDataFromFile(scanner);
                    break;
                case 14:
                    writeDataToFile(scanner);
                    break;
                case 15:
                    appendDataToFile(scanner);
                    break;
                case 16:
                    System.out.println("Exiting system...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPatient(Scanner scanner) {
    	int ID = Exceptions.patientID(scanner);
        String name = Exceptions.name(scanner);
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Gender gender = Exceptions.gender(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        long phone = Exceptions.phone(scanner);

        Patient patient = new Patient(name, age, gender, address, email, phone, 0, "", 0, ID, null, null);
        Person.addPatient(patient);
        System.out.println("Patient added successfully!");
    }

    private static void removePatient(Scanner scanner) {
        System.out.print("Enter the ID of the patient: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        for (Patient patient : Person.getPatients()) {
            if (patient.getPatientID() == ID) {
                Person.removePatient(patient);
                System.out.println("Patient removed successfully!");
                return;
            }
        }
        System.out.println("Patient not found.");
    }
    private static void addDoctor(Scanner scanner) {
    	int ID = Exceptions.doctorID(scanner);
        String name = Exceptions.name(scanner).trim().toUpperCase();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Gender gender = Exceptions.gender(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        long phone = Exceptions.phone(scanner);
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Experience: ");
        String experience = scanner.nextLine();

        Doctor doctor = new Doctor(ID, name, age, gender, address, email, phone, "Doctor", LocalDate.now(), salary, "",
                "Active", specialization, experience, null);
        Employee.addEmployee(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void removeDoctor(Scanner scanner) {
    	System.out.print("Enter the doctor's ID: ");
    	int ID = scanner.nextInt();
    	scanner.nextLine();
        for (Employee e : Employee.getEmployees()) {
            if (e instanceof Doctor && e.getEmployeeID() == ID) {
                Employee.removeEmployee(e);
                System.out.println("Doctor removed successfully!");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();

        Patient patient = null;
        for (Patient p : Person.getPatients()) {
            if (p.getPatientID() == patientID) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor name: ");
        String doctorName = scanner.nextLine().trim();
        Doctor doctor = null;
        for (Employee emp : Employee.getEmployees()) {
            if (emp instanceof Doctor && emp.getName().equalsIgnoreCase(doctorName)) {
                doctor = (Doctor) emp;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        LocalTime time;
        while (true) {
            System.out.print("Enter Appointment Time (HH:MM): ");
            time = LocalTime.parse(scanner.nextLine());
            boolean timeConflict = false;
            for (Appointment a : Appointment.getAppointments()) {
                if (a.getAppointmentDate().equals(date) && a.getAppointmentTime().equals(time)) {
                    System.out.println("The time you chose is already reserved by " + a.getPatient().getPatientID());
                    timeConflict = true;
                    break;
                }
            }
            if (!timeConflict) {
                break;
            }
        }

        System.out.print("Enter Appointment Description: ");
        String description = scanner.nextLine();

        Appointment appointment = new Appointment(patient, doctor, date, time, description);
        Appointment.addAppointment(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    
    private static void removeAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID to remove appointment: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();

        Appointment.removeAppointment(patientID);
    }
    private static void addMedicalReport(Scanner scanner) {
    	System.out.print("Enter the patient's ID: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        Patient patient = null;
        for (Patient p : Person.getPatients()) {
            if (p.getPatientID() == patientID) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int recordNumber;
        while(true) {
        	System.out.print("Enter Medical Record Number: ");
        	recordNumber = scanner.nextInt();
        	scanner.nextLine();
        	if(recordNumber != patient.getPatientID()) {
        		System.out.print("The Medical Report ID must be equal to the Patient's ID!!!!");
        	}
        	else {
        		break;
        	}
        }
        
        System.out.print("Has Medication? (true/false): ");
        boolean medication = scanner.nextBoolean();
        scanner.nextLine();
        
        String medicationDescription = "none";
        if(medication) {
        	System.out.print("Enter Medication Description: ");
        	medicationDescription = scanner.nextLine();
        }
        System.out.print("Enter Allergy: ");
        String allergy = scanner.nextLine();
        System.out.print("Enter Problem: ");
        String problem = scanner.nextLine();
        System.out.print("Enter Cause: ");
        String cause = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        MedicalReport med = new MedicalReport(recordNumber, medication, medicationDescription, allergy, problem, cause, diagnosis);
        patient.setMedicalReport(med);
        System.out.println("Medical report added successfully!");
    }
    
    private static void displayMedicalReport(Scanner scanner) {
        Patient test = new Patient();
    	int ID;
    	while(true) {
    		System.out.print("Enter the Patient ID");
    		ID = scanner.nextInt();
    		scanner.nextLine();
    		if(test.search(ID) == null)
    			System.out.println("Patient doesnt exist");
    		else {
    			test = test.search(ID).get(0);
    			break;
    		}
    	}

        if (test.getMedicalReport() != null) {
            test.displayReport();
        } else {
            System.out.println("Medical report not found.");
        }
    }
    
    private static void viewAllPatients() {
        for (int i = 0; i < Person.getPatients().size(); i++) {
            System.out.println(Person.getPatients().get(i).toString());
        }
    }

    private static void viewAllDoctors() {
        for (int i = 0; i < Employee.getEmployees().size(); i++) {
            Employee emp = Employee.getEmployees().get(i);
            if (emp instanceof Doctor || emp instanceof Nurse) {
                System.out.println(emp.toString());
            }
        }
    }

    private static void viewAllAppointments() {
        for (int i = 0; i < Appointment.getAppointments().size(); i++) {
            Appointment.getAppointments().get(i).displayAppointment();
        }
    }

    private static void readDataFromFile(Scanner scanner) throws IOException {
        System.out.print("Enter the file name to read data: ");
        String fileName = scanner.nextLine();
        scanner.nextLine();
        FileOperations.readNurseData(fileName);
        
    }

    private static void writeDataToFile(Scanner scanner) throws IOException {
        System.out.print("Enter the file name to save data: ");
        String fileName = scanner.nextLine();
        scanner.nextLine();
        FileOperations.WriteData(fileName);
        

    }
    
    private static void appendDataToFile(Scanner scanner) throws IOException {
        System.out.print("Enter the file name to save data: ");
        String fileName = scanner.nextLine();
        scanner.nextLine();
        FileOperations.appendData(fileName);
        

    }
    //String medication, String dosage, String instructions
    private static void setPrescription(Scanner scanner){
    	Patient test = new Patient();
    	int ID;
    	while(true) {
    		System.out.print("Enter the Patient ID");
    		ID = scanner.nextInt();
    		scanner.nextLine();
    		if(test.search(ID) == null)
    			System.out.println("Patient doesnt exist");
    		else {
    			test = test.search(ID).get(0);
    			break;
    		}
    	}
    		
    	System.out.print("Enter Medication: ");
    	String medication = scanner.nextLine();
    	System.out.print("Enter Dosage: ");
    	String dosage = scanner.nextLine();
    	System.out.print("Enter Instructions: ");
    	String instructions = scanner.nextLine();
    	
    	Prescription prescription = new Prescription(medication, dosage, instructions);
    	test.setPrescription(prescription);
    	System.out.print("Prescription added to "+ test.getName());
    	System.out.println(test.getPrescription().toString());
    }
}








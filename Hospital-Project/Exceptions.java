package Hospital_Abdallah;
import java.util.Scanner;


public class Exceptions {

    public static long phone(Scanner scanner) {
        while (true) {
            System.out.print("Enter Phone 11 digits: ");
            long phone = scanner.nextLong();
            scanner.nextLine(); 

            String phoneStr = String.valueOf(phone);

            if (phoneStr.length() != 11){
                System.out.println("Error: Phone must be 11 digits!!!!");
            } else {
                return phone;
            }
        }
    }

    public static String name(Scanner scanner) {
        while (true) {
            System.out.print("Enter Name (max 50 characters): ");
            String name = scanner.nextLine();

            if (name.length() > 50) {
                System.out.println("Error: Name cannot exceed 50 characters.");
            } else {
                return name;
            }
        }
    }

    public static long nid(Scanner scanner) {
        while (true) {
            System.out.print("Enter National ID (14 digits): ");
            long nid = scanner.nextLong();
            scanner.nextLine(); 

            String nidStr = String.valueOf(nid);

            if (nidStr.length() != 14 || nid < 0) {
                System.out.println("Error: National ID must be 14 digits and cannot be negative.");
            } else {
                return nid;
            }
        }
    }

    public static int patientID(Scanner scanner) {
        while (true) {
        	Patient test = new Patient();
//        	System.out.println("انا جوا ال لووب");
            System.out.print("Enter Patient ID: ");
            int patientID = scanner.nextInt();
            scanner.nextLine();

            if (!test.search(patientID).isEmpty()) {
                System.out.println("Error: Patient ID already exists. Please enter a unique ID.");
            } else {
                return patientID;
            }
        }
    }

    public static Gender gender(Scanner scanner) {
        while (true) {
            System.out.print("Enter Gender (MALE/FEMALE): ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                return Gender.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid gender! Please enter MALE or FEMALE.");
            }
        }
    }
    
    public static int doctorID(Scanner scanner) {
        while (true) {
            System.out.print("Enter Doctor ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            boolean exists = false;
            for (Employee emp : Employee.getEmployees()) {
                if (emp.getEmployeeID() == id) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Error: Doctor ID already exists. Please enter a unique ID.");
            } else {
                return id; 
            }
        }
    }
    
}


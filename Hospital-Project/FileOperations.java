package Hospital_Abdallah;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
public static void appendData(String filename) {
	try {
		FileWriter writer = new FileWriter("/Users/bedos/Desktop/"+filename,true);
		writer.write("\n\n***Doctors***\n");
		for(Employee e : Employee.getEmployees()) {
			if(e instanceof Doctor) {
				writer.write(e.getEmployeeID()+" "+e.getName()+" "+e.getAge()+" "+e.getGender()+" "+e.getAddress()
				+" "+e.getEmail()+" "+e.getPhone()+" "+e.getPosition()+" "+e.getDateOfHire()+" "+e.getSalary()+"\n");
			}
		}
		writer.write("\n***Nurses***\n");
		for(Employee e :  Employee.getEmployees()) {
			if(e instanceof Nurse) {
				writer.write(e.getEmployeeID()+" "+e.getName()+" "+e.getAge()+" "+e.getGender()+" "+ e.getGender()+""
					+e.getAddress()+" "+e.getEmail()+" "+e.getPhone()+" "+e.getPosition()+" "+e.getDateOfHire()+" "+e.getSalary()+"\n");
			}
		}
		System.out.println("Data was successfully appended!!!");
		writer.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
public static void WriteData(String filename) {
	
	try {
		FileWriter writer = new FileWriter("/Users/bedos/Desktop/"+filename); // 7ot fe OOP_final.txt
		writer.write("\n***Doctors***\n");
		for(Employee e : Employee.getEmployees()) {
			if(e instanceof Doctor) {
				writer.write(e.getEmployeeID()+" "+e.getName()+" "+e.getAge()+" "+e.getGender()+" "+e.getAddress()
				+" "+e.getEmail()+" "+e.getPhone()+" "+e.getPosition()+" "+e.getDateOfHire()+" "+e.getSalary()+"\n");
			}
		}
		writer.write("\n***Nurses***\n");
		for(Employee e : Employee.getEmployees()) {
			if(e instanceof Nurse) {
				writer.write(e.getEmployeeID()+" "+e.getName()+" "+e.getAge()+" "+e.getGender()+" "+ e.getGender()+""
					+e.getAddress()+" "+e.getEmail()+" "+e.getPhone()+" "+e.getPosition()+" "+e.getDateOfHire()+" "+e.getSalary()+"\n");
			}
		}
		System.out.println("Data was successfully written!!!");
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static ArrayList<Employee> readNurseData(String filename){
	ArrayList<Employee> nurses = new ArrayList<>();
	File file = new File("/Users/bedos/Desktop/"+filename); //****.txt -> OOP_final.txt
	
	try {
		Scanner in = new Scanner(file);
        while (in.hasNext()) {
                int ID = in.nextInt();
                String name = in.next();
                int age = in.nextInt();
                String genderStr = in.next();
                Gender gender = Gender.valueOf(genderStr.toUpperCase());
                String address = in.next();
                String email = in.next();
                long phone = in.nextLong();
                String position = in.next();
                LocalDate hireDate = LocalDate.parse(in.next());
                double salary = in.nextDouble();
                String shift = in.next();
                String employmentStatus = in.next();
                String specialization = in.next();
                String clinicalSkills = in.next();
                String medicalProcedures = in.next();
                String careExperience = in.next();
                String certificate = in.next();
                int patientLoad = in.nextInt();
                String medLicenseNumber = in.next();

                Nurse nurse = new Nurse(
                        ID, name, age, gender, address, email, phone, position, hireDate, salary, shift, 
                        employmentStatus, specialization, clinicalSkills, medicalProcedures, careExperience,
                        certificate, patientLoad, medLicenseNumber
                );

                Employee.addEmployee(nurse);
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + file.getAbsolutePath());
    }
	System.out.println("Data was successfully read!!!");
	return nurses;

}
}

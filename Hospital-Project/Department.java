package Hospital_Abdallah;

import java.util.ArrayList;

public class Department {
	private String name;
    private int departmentId;
    private String depLocation;
    private Doctor headofDep;
    public static ArrayList<Employee> deptEmps;

    public Department() {
        this.name = "";
        this.departmentId = 0;
        this.depLocation = "";
        this.headofDep = null;

    }

    public Department(String name, int departmentId) {
        if (name == null || name.trim().isEmpty()) { // -> trim()bysheel el spaces 3shan yt2kd en el string fady s7 "   " -> "" = fady
            throw new IllegalArgumentException("Department name cannot be null or empty!!");
        }
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be a positive integer!!!!!");
        }
        else if(departmentId > 5)
        	throw new IllegalArgumentException("ONLY DEPARTMENTS CAN EXIST!!!!!");
        
        this.name = name;
        this.departmentId = departmentId;
        this.depLocation = "";
        this.headofDep = null;
    }

    public Department(String name, int departmentId, String depLocation, Doctor headofDep) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be a positive integer.");
        }
        if (depLocation == null || depLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Department location cannot be null or empty.");
        }
        this.name = name;
        this.departmentId = departmentId;
        this.depLocation = depLocation;
        this.headofDep = headofDep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be a positive integer.");
        }
        this.departmentId = departmentId;
    }

    public String getDepLocation() {
        return depLocation;
    }

    public void setDepLocation(String depLocation) {
        if (depLocation == null || depLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Department location cannot be null or empty.");
        }
        this.depLocation = depLocation;
    }

    public Doctor getHeadofDep() {
        return headofDep;
    }

    public void setHeadofDep(Doctor headofDep) {
        this.headofDep = headofDep;
    }


    @Override
    public String toString() {
        return "Department [Name: " + name +
                ", Department ID: " + departmentId +
                ", Location: " + depLocation +
                ", Head of Department: " + (headofDep != null ? headofDep.getName() : "None") +
                ", Number of Employees: " + deptEmps.size() + "]";
    }
}


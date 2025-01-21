package Hospital_Abdallah;

public final class Prescription {
    
    private final String medication;
    private final String dosage;
    private final String instructions;
    
    public Prescription() {
        this.medication = "";
        this.dosage = "";
        this.instructions = "";
    }
    
    public Prescription(String medication, String dosage, String instructions) {
        if (medication == null || medication.trim().isEmpty()) {
            throw new IllegalArgumentException("Medication cannot be null or empty.");
        }
        if (dosage == null || dosage.trim().isEmpty()) {
            throw new IllegalArgumentException("Dosage cannot be null or empty.");
        }
        if (instructions == null || instructions.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructions cannot be null or empty.");
        }
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
    }
    
    public String getMedication() {
        return medication;
    }
    
    public String getDosage() {
        return dosage;
    }
    
    public String getInstructions() {
        return instructions;
    }

	@Override
	public String toString() {
		return "Prescription [medication=" + medication + ", dosage=" + dosage + ", instructions=" + instructions + "]";
	}   
    
}

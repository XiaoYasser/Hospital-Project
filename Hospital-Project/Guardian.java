package Hospital_Abdallah;

public class Guardian extends Person {
	private String relationship;
    private long NID;

    public Guardian(String name, int age, Gender gender, String address, String email, long phone, 
                    String relationship, long NID) {
        super(name, age, gender, address, email, phone);
        if (relationship == null || relationship.trim().isEmpty()) {
            throw new IllegalArgumentException("Relationship cannot be null or empty.");
        }
        if (NID <= 0) {
            throw new IllegalArgumentException("NID must be a positive number.");
        }
        this.relationship = relationship;
        this.NID = NID;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        if (relationship == null || relationship.trim().isEmpty()) {
            throw new IllegalArgumentException("Relationship cannot be null or empty.");
        }
        this.relationship = relationship;
    }

    public long getNID() {
        return NID;
    }

    public void setNID(long NID) {
        if (NID <= 0) {
            throw new IllegalArgumentException("NID must be a positive number.");
        }
        this.NID = NID;
    }

    @Override
    public void provideIdentification() {
        System.out.println("Guardian Name: " + getName() + ", NID: " + NID);
    }
    
    @Override
    public String toString() {
        return "Guardian [Name: " + getName() + ", Relationship: " + relationship + 
               ", NID: " + NID + ", Age: " + getAge() + ", Gender: " + getGender() +
               ", Phone: " + getPhone() + "]";
    }
}


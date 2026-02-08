package model;

public class Patient {
    private String name;
    private String birthDate;
    private String sex; // "M" or "F"
    private String sampleId;
    private String address;
    private String dateOfCollection;
    private String timeCollection;
    private String timeOfLastMeal;
    private String requestingPhysician;
    
    public Patient(String name, String birthDate, String sex, String sampleId, String address) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.sampleId = sampleId;
        this.address = address;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    
    public String getSampleId() { return sampleId; }
    public void setSampleId(String sampleId) { this.sampleId = sampleId; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getDateOfCollection() { return dateOfCollection; }
    public void setDateOfCollection(String dateOfCollection) { this.dateOfCollection = dateOfCollection; }
    
    public String getTimeCollection() { return timeCollection; }
    public void setTimeCollection(String timeCollection) { this.timeCollection = timeCollection; }
    
    public String getTimeOfLastMeal() { return timeOfLastMeal; }
    public void setTimeOfLastMeal(String timeOfLastMeal) { this.timeOfLastMeal = timeOfLastMeal; }
    
    public String getRequestingPhysician() { return requestingPhysician; }
    public void setRequestingPhysician(String requestingPhysician) { this.requestingPhysician = requestingPhysician; }
}

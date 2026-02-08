package model;

public class TestResult {
    private String testName;
    private double value;
    private String unit;
    private String referenceRange;
    private String interpretation; // LOW, NORMAL, HIGH
    
    public TestResult(String testName, double value, String unit, String referenceRange, String interpretation) {
        this.testName = testName;
        this.value = value;
        this.unit = unit;
        this.referenceRange = referenceRange;
        this.interpretation = interpretation;
    }
    
    // Getters and Setters
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }
    
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    
    public String getReferenceRange() { return referenceRange; }
    public void setReferenceRange(String referenceRange) { this.referenceRange = referenceRange; }
    
    public String getInterpretation() { return interpretation; }
    public void setInterpretation(String interpretation) { this.interpretation = interpretation; }
}

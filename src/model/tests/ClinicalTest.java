package model.tests;

import model.TestResult;

public class ClinicalTest {
    private String testName;
    private String unit;
    private double minValue;
    private double maxValue;
    private double minValueFemale;
    private double maxValueFemale;
    private boolean hasSexSpecificRange;
    
    // Constructor for tests with same range for both sexes
    public ClinicalTest(String testName, String unit, double minValue, double maxValue) {
        this.testName = testName;
        this.unit = unit;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.hasSexSpecificRange = false;
    }
    
    // Constructor for tests with sex-specific ranges
    public ClinicalTest(String testName, String unit, double minMale, double maxMale, double minFemale, double maxFemale) {
        this.testName = testName;
        this.unit = unit;
        this.minValue = minMale;
        this.maxValue = maxMale;
        this.minValueFemale = minFemale;
        this.maxValueFemale = maxFemale;
        this.hasSexSpecificRange = true;
    }
    
    public TestResult evaluate(double value, String sex) {
        double min, max;
        String range;
        
        if (hasSexSpecificRange && sex.equalsIgnoreCase("F")) {
            min = minValueFemale;
            max = maxValueFemale;
            range = "F: " + min + "-" + max;
        } else {
            min = minValue;
            max = maxValue;
            if (hasSexSpecificRange) {
                range = "M: " + min + "-" + max;
            } else {
                range = min + "-" + max;
            }
        }
        
        String interpretation;
        if (value < min) {
            interpretation = "LOW";
        } else if (value > max) {
            interpretation = "HIGH";
        } else {
            interpretation = "NORMAL";
        }
        
        return new TestResult(testName, value, unit, range, interpretation);
    }
    
    // Getters
    public String getTestName() { return testName; }
    public String getUnit() { return unit; }
    public double getMinValue() { return minValue; }
    public double getMaxValue() { return maxValue; }
}

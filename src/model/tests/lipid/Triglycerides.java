package model.tests.lipid;

import model.TestResult;
import model.tests.ClinicalTest;

public class Triglycerides {
    private ClinicalTest test;
    
    public Triglycerides() {
        // Triglycerides: M: 0.68-1.88, F: 0.46-1.6 mmol/L (sex-specific)
        this.test = new ClinicalTest("Triglycerides", "mmol/L", 0.68, 1.88, 0.46, 1.6);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

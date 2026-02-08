package model.tests.electrolyte;

import model.TestResult;
import model.tests.ClinicalTest;

public class Chloride {
    private ClinicalTest test;
    
    public Chloride() {
        // Chloride: 96.0-110.0 mmol/L (same for both sexes)
        this.test = new ClinicalTest("Chloride", "mmol/L", 96.0, 110.0);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

package model.tests.electrolyte;

import model.TestResult;
import model.tests.ClinicalTest;

public class Sodium {
    private ClinicalTest test;
    
    public Sodium() {
        // Sodium: 135.0-145.0 mmol/L (same for both sexes)
        this.test = new ClinicalTest("Sodium", "mmol/L", 135.0, 145.0);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

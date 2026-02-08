package model.tests.kidney;

import model.TestResult;
import model.tests.ClinicalTest;

public class UricAcid {
    private ClinicalTest test;
    
    public UricAcid() {
        // Uric Acid: M: 0.21-0.42, F: 0.15-0.35 mmol/L (sex-specific)
        this.test = new ClinicalTest("Uric Acid", "mmol/L", 0.21, 0.42, 0.15, 0.35);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

package model.tests.kidney;

import model.TestResult;
import model.tests.ClinicalTest;

public class Creatinine {
    private ClinicalTest test;
    
    public Creatinine() {
        // Creatinine: M: 79.6-114.9, F: 53.0-106.08 umol/L (sex-specific)
        this.test = new ClinicalTest("Creatinine", "umol/L", 79.6, 114.9, 53.0, 106.08);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

package model.tests.lipid;

import model.TestResult;
import model.tests.ClinicalTest;

public class HDLCholesterol {
    private ClinicalTest test;
    
    public HDLCholesterol() {
        // HDL: M: 0.91-2.08, F: 1.09-2.29 mmol/L (sex-specific)
        this.test = new ClinicalTest("HDL", "mmol/L", 0.91, 2.08, 1.09, 2.29);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

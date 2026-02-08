package model.tests.liver;

import model.TestResult;
import model.tests.ClinicalTest;

public class ALT {
    private ClinicalTest test;
    
    public ALT() {
        // ALT/SGPT: <0.83 uKat/L (same for both sexes)
        this.test = new ClinicalTest("ALT/SGPT", "uKat/L", 0, 0.83);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

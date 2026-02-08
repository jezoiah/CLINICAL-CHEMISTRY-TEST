package model.tests.kidney;

import model.TestResult;
import model.tests.ClinicalTest;

public class BloodUreaNitrogen {
    private ClinicalTest test;
    
    public BloodUreaNitrogen() {
        // BUN: 2.14-7.14 mmol/L (same for both sexes)
        this.test = new ClinicalTest("BUN", "mmol/L", 2.14, 7.14);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

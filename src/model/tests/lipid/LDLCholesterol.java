package model.tests.lipid;

import model.TestResult;
import model.tests.ClinicalTest;

public class LDLCholesterol {
    private ClinicalTest test;
    
    public LDLCholesterol() {
        // LDL: 1.3-3.38 mmol/L (same for both sexes)
        this.test = new ClinicalTest("LDL", "mmol/L", 1.3, 3.38);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

package model.tests.electrolyte;

import model.TestResult;
import model.tests.ClinicalTest;

public class TotalCalcium {
    private ClinicalTest test;
    
    public TotalCalcium() {
        // Total Calcium: 2.15-2.57 mmol/L (same for both sexes)
        this.test = new ClinicalTest("TCalcium", "mmol/L", 2.15, 2.57);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

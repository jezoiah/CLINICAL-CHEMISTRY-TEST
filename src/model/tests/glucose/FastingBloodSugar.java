package model.tests.glucose;

import model.TestResult;
import model.tests.ClinicalTest;

public class FastingBloodSugar {
    private ClinicalTest test;
    
    public FastingBloodSugar() {
        // FBS: 4.07-5.5 mmol/L (same for both sexes)
        this.test = new ClinicalTest("FBS", "mmol/L", 4.07, 5.5);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

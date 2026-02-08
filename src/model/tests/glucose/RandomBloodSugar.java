package model.tests.glucose;

import model.TestResult;
import model.tests.ClinicalTest;

public class RandomBloodSugar {
    private ClinicalTest test;
    
    public RandomBloodSugar() {
        // RBS: 4.07-7.8 mmol/L (same for both sexes)
        this.test = new ClinicalTest("RBS", "mmol/L", 4.07, 7.8);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

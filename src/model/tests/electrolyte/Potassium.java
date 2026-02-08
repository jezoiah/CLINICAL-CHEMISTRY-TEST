package model.tests.electrolyte;

import model.TestResult;
import model.tests.ClinicalTest;

public class Potassium {
    private ClinicalTest test;
    
    public Potassium() {
        // Potassium: 3.5-5.0 mmol/L (same for both sexes)
        this.test = new ClinicalTest("Potassium", "mmol/L", 3.5, 5.0);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

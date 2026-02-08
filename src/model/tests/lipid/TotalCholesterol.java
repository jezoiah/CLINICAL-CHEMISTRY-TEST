package model.tests.lipid;

import model.TestResult;
import model.tests.ClinicalTest;

public class TotalCholesterol {
    private ClinicalTest test;
    
    public TotalCholesterol() {
        // Total Cholesterol: 3.9-5.72 mmol/L (same for both sexes)
        this.test = new ClinicalTest("Total Cholesterol", "mmol/L", 3.9, 5.72);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

package model.tests.electrolyte;

import model.TestResult;
import model.tests.ClinicalTest;

public class IonizedCalcium {
    private ClinicalTest test;
    
    public IonizedCalcium() {
        // Ionized Calcium: 1.10-1.30 mmol/L (same for both sexes)
        this.test = new ClinicalTest("ICalcium", "mmol/L", 1.10, 1.30);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

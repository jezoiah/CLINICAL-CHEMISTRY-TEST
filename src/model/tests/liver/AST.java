package model.tests.liver;

import model.TestResult;
import model.tests.ClinicalTest;

public class AST {
    private ClinicalTest test;
    
    public AST() {
        // AST/SGOT: <0.76 uKat/L (same for both sexes)
        this.test = new ClinicalTest("AST/SGOT", "uKat/L", 0, 0.76);
    }
    
    public TestResult evaluate(double value, String sex) {
        return test.evaluate(value, sex);
    }
    
    public String getTestName() {
        return test.getTestName();
    }
}

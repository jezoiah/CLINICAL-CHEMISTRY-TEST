## Team Members
- **Javier, Jezoar Uzziah J.**
- **Dela Pena, Chriselle Kim M.**

### [Javier, Jezoar Uzziah J.] - Responsibilities:
- Patient.java (model/)
- All Electrolyte tests (tests/glucose/)
- All Kidney tests (tests/lipid/)
- Compilation scripts
- Documentation/Planning (README.md)

### [Dela Pena, Chriselle Kim M.] - Responsibilities:
- All Glucose tests (tests/kidney/)
- All Lipid tests (tests/liver/)
- All Liver tests (tests/electrolyte/)
- TestResult.java (model/)
- Main application (ClinicalChemistryApp.java)

### Project Structure
```
ClinicalChemistryLab/
│
├── src/
│   ├── model/             
│   │   ├── Patient.java          ← JAVIER
│   │   └── TestResult.java       ← DELA PENA
│   │
│   ├── tests/
│   │   ├── glucose/              ← DELA PENA
│   │   │   ├── FastingBloodSugar.java
│   │   │   └── RandomBloodSugar.java
│   │   │
│   │   ├── lipid/                ← DELA PENA
│   │   │   ├── TotalCholesterol.java
│   │   │   ├── HDLCholesterol.java
│   │   │   ├── LDLCholesterol.java
│   │   │   └── Triglycerides.java
│   │   │
│   │   ├── kidney/               ← JAVIER
│   │   │   ├── Creatinine.java
│   │   │   ├── UricAcid.java
│   │   │   └── BloodUreaNitrogen.java
│   │   │
│   │   ├── liver/                ← DELA PENA
│   │   │   ├── AST.java
│   │   │   └── ALT.java
│   │   │
│   │   └── electrolyte/          ← JAVIER
│   │       ├── Sodium.java
│   │       ├── Potassium.java
│   │       ├── Chloride.java
│   │       ├── TotalCalcium.java
│   │       └── IonizedCalcium.java
│   │
│   └── ClinicalChemistryApp.java    ← DELA PENA
│
│
├── README.md                        ← JAVIER
│
│
└── compile.sh / compile.ps1         ← JAVIER

```
## How to Run
**bash**
```bash
chmod +x compile.sh
./compile.sh
java -cp bin ClinicalChemistryApp
```

**powershell**
```powershell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
.\compile.ps1
java -cp bin ClinicalChemistryApp
```

## Collaboration Tools
- Git/GitHub for version control
- Daily meetings for integration


---

## Project Overview

This JavaFX application simulates a Clinical Chemistry Laboratory Diagnostic system for evaluating patient test results based on sex-specific reference ranges.

### Features
- ✅ Patient information management
- ✅ 15 clinical chemistry tests
- ✅ Sex-specific reference ranges (Male/Female)
- ✅ Automatic result interpretation (LOW/NORMAL/HIGH)
- ✅ Color-coded results display
- ✅ JavaFX GUI with modern interface

### Available Tests
1. **Glucose Tests**: FBS, RBS
2. **Lipid Profile**: Total Cholesterol, HDL, LDL, Triglycerides
3. **Kidney Function**: Creatinine, Uric Acid, BUN
4. **Liver Function**: AST/SGOT, ALT/SGPT
5. **Electrolytes**: Sodium, Potassium, Chloride, Total Calcium, Ionized Calcium

## Setup Instructions

### Prerequisites
1. Java JDK 11 or higher
2. JavaFX SDK - Download from [https://openjfx.io/](https://openjfx.io/)

### Installation

1. **Download and Extract JavaFX SDK**
   ```bash
   # Example path: C:\javafx-sdk or /usr/local/javafx-sdk
   ```

2. **Set Environment Variable**
   
   **Windows (PowerShell):**
   ```powershell
   $env:PATH_TO_FX = "C:\path\to\javafx-sdk\lib"
   ```
   
   **macOS/Linux:**
   ```bash
   export PATH_TO_FX=/path/to/javafx-sdk/lib
   ```

3. **Compile**
   
   **Windows:**
   ```powershell
   .\compile.ps1
   ```
   
   **macOS/Linux:**
   ```bash
   chmod +x compile.sh
   ./compile.sh
   ```

4. **Run**
   ```bash
   java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp bin ClinicalChemistryApp
   ```

## Usage Guide

1. Enter patient information (name, birth date, sex, sample ID, address)
2. Select tests by checking the boxes
3. Enter measured values for each selected test
4. Click "Generate Test Results"
5. View color-coded interpretations in the results table

## OOP Principles

### Encapsulation (Main Focus)
This project demonstrates **encapsulation** - the fundamental OOP principle of data hiding:

**Patient.java:**
- Private fields: name, birthDate, sex, sampleId, address
- Public getters and setters to control access
- Data is protected and accessed only through methods

**TestResult.java:**
- Private fields: testName, value, unit, referenceRange, interpretation
- Public getters and setters
- Encapsulates test result data

**ClinicalTest.java:**
- Private fields: testName, unit, minValue, maxValue, etc.
- Public methods: evaluate(), getters
- Hides the logic for determining LOW/NORMAL/HIGH

**All Test Classes (15 classes):**
- Each has a private ClinicalTest object
- Public evaluate() method
- Encapsulates specific test reference ranges

## Sample Test Data

**Normal Male Patient:**
- FBS: 4.5 mmol/L → NORMAL
- Total Cholesterol: 4.5 mmol/L → NORMAL
- Creatinine: 90 umol/L → NORMAL

**Abnormal Female Patient:**
- FBS: 7.0 mmol/L → HIGH
- HDL: 0.8 mmol/L → LOW
- Triglycerides: 2.0 mmol/L → HIGH

## Reference Ranges Source

All reference ranges are based on the Clinical Chemistry Diagnostic.xlsx spreadsheet provided by the instructor, using S.I. Units (mmol/L, umol/L, uKat/L).

## Academic Integrity

This project was developed independently by the team members listed above. All code is original work created for the Intermediate Programming using Java course.

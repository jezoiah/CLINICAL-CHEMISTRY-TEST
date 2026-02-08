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

---

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
5. View interpretations in the results table
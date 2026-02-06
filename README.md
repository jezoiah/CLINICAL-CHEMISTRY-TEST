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
└── compile.sh / compile.bat         ← JAVIER

```
## How to Run
```bash
chmod +x compile.sh
./compile.sh
java -cp bin ClinicalChemistryApp
```

## Collaboration Tools
- Git/GitHub for version control
- Daily meetings for integration
- Google Docs for documentation
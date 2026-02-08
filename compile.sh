#!/bin/bash

# Check if PATH_TO_FX is set
if [ -z "$PATH_TO_FX" ]; then
    echo "Setting PATH_TO_FX..."
    export PATH_TO_FX=~/Desktop/javafx-sdk-25.0.2/lib
fi

# Compile all Java files
echo "Compiling Java files..."
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -d bin -sourcepath src src/ClinicalChemistryApp.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
else
    echo "Compilation failed!"
fi
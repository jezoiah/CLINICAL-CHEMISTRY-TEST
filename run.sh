#!/bin/bash

if [ -z "$PATH_TO_FX" ]; then
    echo "ERROR: PATH_TO_FX environment variable is not set!"
    echo "Please set it to your JavaFX SDK lib directory:"
    echo "export PATH_TO_FX=/path/to/javafx-sdk/lib"
    exit 1
fi

if [ ! -d "bin" ]; then
    echo "Compiled classes not found. Compiling first..."
    ./compile.sh
fi

echo "Running Clinical Chemistry Application..."
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp bin ClinicalChemistryApp

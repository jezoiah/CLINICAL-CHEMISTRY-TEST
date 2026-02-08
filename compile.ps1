Write-Host "Compiling Java files..." -ForegroundColor Green

# Create bin directory if it doesn't exist
if (-not (Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}

# Compile all Java files
javac --module-path $env:PATH_TO_FX --add-modules javafx.controls,javafx.fxml -d bin (Get-ChildItem -Path src -Recurse -Filter *.java).FullName

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "To run the application, use:" -ForegroundColor Yellow
    Write-Host "java --module-path `$env:PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp bin ClinicalChemistryApp" -ForegroundColor Cyan
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}

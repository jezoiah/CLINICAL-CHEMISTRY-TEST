# PowerShell run script for Clinical Chemistry App

if (-not $env:PATH_TO_FX) {
    Write-Host "ERROR: PATH_TO_FX environment variable is not set!" -ForegroundColor Red
    Write-Host "Please set it to your JavaFX SDK lib directory:" -ForegroundColor Yellow
    Write-Host '$env:PATH_TO_FX = "C:\path\to\javafx-sdk\lib"' -ForegroundColor Cyan
    exit 1
}

if (-not (Test-Path "bin")) {
    Write-Host "Compiled classes not found. Compiling first..." -ForegroundColor Yellow
    .\compile.ps1
}

Write-Host "Running Clinical Chemistry Application..." -ForegroundColor Green
java --module-path $env:PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp bin ClinicalChemistryApp

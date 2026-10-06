@echo off
setlocal EnableExtensions
set "ROOT=%~dp0"
set "GRADLE_VERSION=9.6.0"
set "DIST=%ROOT%.gradle-local\gradle-%GRADLE_VERSION%"
set "ZIP=%ROOT%.gradle-local\gradle-%GRADLE_VERSION%-bin.zip"

if not exist "%DIST%\bin\gradle.bat" (
    echo Gradle %GRADLE_VERSION% is not installed for this project.
    echo Downloading it from services.gradle.org...
    if not exist "%ROOT%.gradle-local" mkdir "%ROOT%.gradle-local"
    powershell -NoProfile -ExecutionPolicy Bypass -Command ^
      "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest -Uri 'https://services.gradle.org/distributions/gradle-9.6.0-bin.zip' -OutFile '%ZIP%'"
    if errorlevel 1 (
        echo.
        echo Could not download Gradle. Check your internet connection.
        exit /b 1
    )
    powershell -NoProfile -ExecutionPolicy Bypass -Command ^
      "Expand-Archive -Path '%ZIP%' -DestinationPath '%ROOT%.gradle-local' -Force"
    if errorlevel 1 exit /b 1
)
call "%DIST%\bin\gradle.bat" %*
endlocal

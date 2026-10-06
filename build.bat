@echo off
call "%~dp0gradlew.bat" build
if errorlevel 1 (
  echo.
  echo Build failed.
  pause
  exit /b 1
)
echo.
echo ==========================================
echo BUILD SUCCESSFUL
echo JAR: build\libs\
echo ==========================================
pause

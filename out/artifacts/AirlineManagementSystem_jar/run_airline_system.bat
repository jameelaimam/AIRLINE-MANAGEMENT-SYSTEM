@echo off
REM This batch file will run your AirlineManagementSystem.jar

REM Change the directory below if your JAR is in a different folder
set JAR_NAME=AirlineManagementSystem.jar

REM If Java is installed and on your PATH, this will work:
java -jar "%JAR_NAME%"

REM If you have a specific Java version installed, you can use the full path:
REM "C:\Program Files\Java\jdk-24\bin\javaw.exe" -jar "%JAR_NAME%"
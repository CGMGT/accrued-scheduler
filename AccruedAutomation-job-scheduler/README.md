# Backend Tigo Accrued Automation / Scheduled Tasks
###### Version 1.0

Tareas programadas para Tigo Accrued Automation.

## Configuration
- Spring Boot 2.6.0-SNAPSHOT
- Java 1.8
- Maven 3.6.3

## Dependencies
- JPA
- Web
- Slf4j

## Usage
#### Clone repository
```
git clone https://gitlab-bsd.tigo.com.gt/BSD-APPS/Ventas/AccruedAutomationApp/src.git 
```
#### Project information
```
    <groupId>gt.com.tigo</groupId>
    <artifactId>accrued-automation-scheduled-job</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>
    <name>accrued-automation-scheduled-job</name>
    <description>Tigo Accrued Automation Scheduled Job</description>
```
#### Base package
```
    gt.com.tigo.accruedautomation
```
#### Main class
```
    public class AccruedAutomationApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
        ...
    }
```
#### Main class path
```
    <project-path>/src/main/java/gt/com/tigo/accruedautomation/AccruedAutomationApplication.java
```
#### Weblogic configuration
```
    <wls:context-root>/accrued-automation-scheduled-job</wls:context-root>
```
#### Build
```
mvn package
```
#### API Documentation
```
N/A
```
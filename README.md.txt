E-commerce Test Automation Framework
This repository contains a Hybrid Test Automation Framework developed for a demo E-commerce application.  
The framework is built using Java, Selenium WebDriver, TestNG, and Maven with Jenkins integration for Continuous Integration.
Tools & Technologies Used
•	Language: Java V 17.0.12
•	Automation Tool: Selenium WebDriver
•	Build Tool: Maven V 3.9.9
•	Test Framework: TestNG
•	CI/CD: Jenkins
•	IDE: Eclipse
•	Version Control: GitHub
Framework Features
•	Page Object Model (POM) design pattern  
•	Data-Driven Testing (using Excel)  
•	TestNG for test case management and reporting  
•	Maven for dependency management  
•	Parallel execution with TestNG XML  
•	Jenkins integration for CI/CD pipeline  
•	Screenshots captured on test failure  
Project Structure
ecommerce-test-automation/
│── src/main/java
│ ├── pages/ # Page classes (POM)
│ ├── utils/ # Utilities (Excel reader, config loader, etc.)
│── src/test/java
│ ├── tests/ # Test cases
│── testng.xml # Test suite configuration
│── pom.xml # Maven dependencies
How to Run Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Selenium_Ecom-WebAutomation.git
2.	Navigate into the project:
3.	cd Selenium_Ecom_WebAutomation
4.	Run with Maven: mvn clean test
5.	Run with TestNG: mvn test -Pgroups.xml
________________________________________
Reports
•	TestNG generates HTML reports in test-output/ folder after execution.
•	Screenshots of failed tests stored in screenshots/ folder.
________________________________________
Contribution
Feel free to fork this repo and suggest improvements.


Hospital Management Staff Web Application

This is a web application built using Java Spring Boot for managing hospital staff. It provides REST APIs for various functionalities related to signup, login, admitting patients, fetching admitted patients, and discharging patients.

Prerequisites:
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL database

Setup Instructions:
1. Clone the repository to your local machine.
2. Configure the MySQL database by creating a database with the name 'hospital_management' (you can change the database name in the 'application.properties' file).
3. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
4. Build the project using Maven to download the required dependencies and compile the source code.
5. Run the project by executing the main class 'HospitalManagementApplication.java' or using the 'mvn spring-boot:run' command.

API Documentation:
- Signup API: [POST] /api/staff/signup
  - Register a new staff member with the provided details (name, email, password).
  - 
- Login API: [POST] /api/satff/login
  - Authenticate the staff member by providing the email and password.
  - 
- Admit Patient API: [POST] /api/patients/admit
  - Admit a new patient with details such as name, age, room, doctor name, admit date, expenses, and status.
  - 
- Fetch Admitted Patients API: [GET] /api/patients/getAllAdmitPatients
  - Get a list of all patients currently admitted to the hospital.
  - 
- Discharge Patient API: [Post] /api/patients/discharge/{id}
  - Discharge a patient with the specified ID and update the status of patient to discharged

Project Structure:
- src/main/java: Contains the Java source code.
  - com.hospital.management.staff: Main package.
    - config: Configuration classes for Spring Boot.
    - controller: REST API controllers.
    - model: Entity models.
    - repository: Data access interfaces.
    - service: Business logic services.
- src/main/resources: Contains application properties and static files.
  - application.properties: Configuration properties for the application.
  - static: Contains templates for signup and login form 

Note: Please make sure to update the database connection details in the 'application.properties' file, such as the database URL, username, and password, to match your MySQL setup.

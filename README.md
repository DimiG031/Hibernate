# Employee Database Management with Hibernate

## Overview
This project is a **Java application** that utilizes **Hibernate** for managing an employee database. It demonstrates how to perform CRUD (Create, Read, Update, Delete) operations using Hibernate ORM in a Maven-based project.

## Features
- **Database Integration**: Connects to an employee database using Hibernate.
- **CRUD Operations**: Allows for creating, reading, updating, and deleting employee records.
- **Object-Relational Mapping**: Demonstrates mapping between Java classes and database tables.

## Installation & Usage

### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven 3.6 or later
- A relational database system (e.g., MySQL, PostgreSQL)

### Setup Instructions
1. **Clone the repository**:
   ```sh
   git clone https://github.com/DimiG031/Hibernate.git
   cd Hibernate
   ```
2. **Configure the database**:
   - Create a database named `baza_zaposlenih`.
   - Execute the `baza_zaposlenih_zaposleni.sql` script to create the necessary tables.
   - Update the database connection properties in the `src/main/resources/hibernate.cfg.xml` file.

3. **Build the project using Maven**:
   ```sh
   mvn clean install
   ```

4. **Run the application**:
   ```sh
   mvn exec:java -Dexec.mainClass="com.example.Main"
   ```

## Future Improvements
- **User Interface**: Develop a graphical user interface for easier interaction.
- **Validation**: Implement input validation to ensure data integrity.
- **Logging**: Add logging functionality for better debugging and monitoring.

## License
This project is open-source under the [MIT License](LICENSE).

---
📩 Feel free to contribute, suggest features, or report issues!


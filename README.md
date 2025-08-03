

# Spring Boot E-commerce Application

A basic e-commerce system built using Spring Boot, featuring product, customer, and order management through RESTful APIs.

## Features
- Add/view products
- Register/view customers
- Create/view orders (with product mapping)
- Connects to PostgreSQL using Spring Data JPA

## Technologies
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok


##  Prerequisites & Installation

Before running this project, make sure the following tools are installed on your machine:

###  1. Install Java JDK 21+
- Download from: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html  
- Or use SDKMAN (Linux/macOS):
  
  sdk install java 21.0.8-tem

###  2. Install Maven
- Download: https://maven.apache.org/download.cgi

- Check installation:

  mvn -v



### 3. Install PostgreSQL
Download: https://www.postgresql.org/download/

Create a new database:
CREATE DATABASE ecommerce_db;


---

## 🧠 Run Project with Eclipse IDE

If you prefer running the project using Eclipse IDE, follow these steps:

### 🔹 1. Prerequisites

Make sure you’ve installed:
- [PostgreSQL](https://www.postgresql.org/download/)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/)
- [Lombok Plugin for Eclipse](https://projectlombok.org/setup/eclipse)

### 🔹 2. Import Project into Eclipse

1. **Open Eclipse**  
2. Go to `File` > `Import` > `Existing Maven Projects`
3. Browse to the cloned `springboot-ecommerce` directory
4. Make sure it finds the `pom.xml`, then click **Finish**

### 🔹 3. Enable Lombok in Eclipse

1. **Install Lombok JAR** (if not already):
   - Download from: https://projectlombok.org/download
   - Run the downloaded JAR:
     ```bash
     java -jar lombok.jar
     ```
   - Point it to your Eclipse installation directory and click **Install/Update**

2. **Enable Annotation Processing** in Eclipse:
   - Right-click on your project > `Properties`
   - Go to `Java Compiler > Annotation Processing` and **enable**
   - Apply and close

### 🔹 4. Configure the Database

Edit the `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


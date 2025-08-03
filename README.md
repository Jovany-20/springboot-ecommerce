

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


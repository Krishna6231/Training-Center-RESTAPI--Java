
# Traini8 - Training Center Registry MVP

## Overview

Traini8 is a startup focused on creating a Minimum Viable Product (MVP) for a registry of Government-funded Training Centers. This MVP is designed to fulfill the basic requirements outlined in the problem statement.

## Features

- **Registration of Training Centers**: Users can create and save new training centers with various details including center name, code, address, student capacity, courses offered, contact information, and creation timestamp.
  
- **Retrieval of Training Centers**: Users can retrieve a list of all stored training centers' information.
  
- **Validation**: Proper validation is implemented for mandatory fields, email, phone number, and size constraints.
  
- **Exception Handling**: An ExceptionHandler is implemented to handle validation failures and other exceptions gracefully.
  
- **Search and Filter**: Ability to filter data in the list API based on center name.

## Technologies Used

- **Spring Boot**: Used for creating the backend application.
  
- **Java**: Programming language used for backend development.
  
- **MongoDB**: NoSQL database used for persisting training center information.
  
- **Spring Data MongoDB**: Object Document Mapper (ODM) used for database interaction.
  
- **Maven**: Dependency management and build tool.

## Setup Instructions

## MongoDB Setup and Configuration

### Installing MongoDB Locally or Accessing a Remote Instance

#### Local Installation:

If you don't have MongoDB installed locally, you can download and install it from the [official MongoDB website](https://www.mongodb.com/try/download/community). Follow the installation instructions provided for your operating system.

#### Accessing a Remote MongoDB Instance:

If you have access to a remote MongoDB instance, ensure you have the necessary connection details provided by your administrator or service provider.

### Configuration Settings

#### Database URL:

Update the `spring.data.mongodb.uri` property in the `application.properties` or `application.yml` file with the MongoDB connection URL. Replace `"mongodb://localhost:27017/mydatabase"` with your MongoDB connection URL.

#### Username and Password:

If your MongoDB instance requires authentication, include the username and password in the connection URL. For example, `"mongodb://username:password@localhost:27017/mydatabase"`. Update the `spring.data.mongodb.username` and `spring.data.mongodb.password` properties in the `application.properties` or `application.yml` file with your MongoDB username and password.

#### Other Necessary Details:

Review any other configuration settings required by your MongoDB instance, such as authentication mechanisms, replica set configuration, SSL/TLS settings, etc. Ensure these details are correctly configured in the application properties file.

### Application Configuration

#### Updating `application.properties` or `application.yml`:

1. Open the `application.properties` or `application.yml` file in your Spring Boot project.
2. Update the MongoDB connection properties with the appropriate values based on your MongoDB setup and configuration.
3. Save the changes to the file.

   
### Method 1: Using IntelliJ IDEA (Suggested)

1. **Clone the Repository**: 
   ```
   git clone https://github.com/your_username/traini8.git
   ```

2. **Navigate to the Project Directory**:
   ```
   cd traini8
   ```

3. **Configure MongoDB**:
   - Make sure MongoDB is installed and running locally.
   - Update the MongoDB connection properties in `application.properties` if necessary.

4. **Open Project in IntelliJ IDEA**:
   - Open IntelliJ IDEA.
   - Click on `File` > `Open` and select the project directory (`traini8`).

5. **Run the Application**:
   - Navigate to the main application file (`Traini8Application.java`) located in `src/main/java/com/example/Traini8`.
   - Right-click on the file and select `Run Traini8Application`.

6. **Accessing the APIs**:
   - Once the application is running, you can access the APIs using the following base URL:
     ```
     http://localhost:8080
     ```

### Method 2: Using Maven

1. **Clone the Repository**: 
   ```
   git clone https://github.com/your_username/traini8.git
   ```

2. **Navigate to the Project Directory**:
   ```
   cd traini8
   ```

3. **Build and Run the Application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the APIs**:
   - Use tools like Postman to access the following APIs:
     - **POST `/trainingCenters/signup`**: Create and save a new training center.
     - **GET `/trainingCenters/fetchAll`**: Retrieve a list of all stored training centers.
     - **GET `/trainingCenters/{centerName}`**: Retrieve detailed information about a specific training center by center name.
     - **GET `/trainingCenters/search`**: Filter data in the list API based on center name.

## Usage

1. **Register a New Training Center**:
   - Send a POST request to `/trainingCenters/signup` with the required JSON payload.

2. **Retrieve Training Centers**:
   - Send a GET request to `/trainingCenters/fetchAll` to get a list of all stored training centers.

3. **Search and Filter**:
   - Send a GET request to `/trainingCenters/search` with parameters to filter data based on center name.
  
   **Example URLs for usage**:
      - Registering a new training center: http://localhost:8080/trainingCenters/signup
      - Retrieving all training centers: http://localhost:8080/trainingCenters/fetchAll
      - Retrieving a specific training center by name: http://localhost:8080/trainingCenters/{centerName}
      - Searching and filtering: http://localhost:8080/trainingCenters/search?centerName={centerName}

## Contributors

- Krishna Paramathma Modi


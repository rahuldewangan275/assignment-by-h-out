# Optimize HTTP Server

This project is a simple HTTP server implemented using Spring Boot that meets specific requirements, including handling GET requests on the `/data` endpoint with query parameters.

## Project Structure

The project structure includes the following key components:

- `src/main/java/com/example/demo/DataController.java`: Implements the HTTP endpoints for retrieving file content based on specified query parameters.

- `Dockerfile`: Specifies the instructions for building the Docker image.

## Getting Started

### Prerequisites

Make sure you have the following installed on your machine:

- Java
- Maven
- Docker

### Setup

1. Clone the repository:

   ```bash
   git clone <repository-url>



## Test the HTTP server endpoints:

To retrieve the entire file content: http://localhost:8080/data?n=1

To retrieve a specific line: http://localhost:8080/data?n=1&m=30


## File Generation
Generate sample data files with random content and place them in the src/main/resources/data/ directory.


## Exception Handling
The server includes exception handling to handle scenarios where the file is not found or there is an issue reading the file content.


## Customization
Feel free to customize the project based on your specific requirements.







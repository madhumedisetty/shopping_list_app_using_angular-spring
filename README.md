# Shopping List Application

This is a full-stack shopping list application that allows users to manage their shopping items. The application is built with Angular for the front end and Spring Boot for the back end.

## Project Structure

- **Front End**: The front end is located in the `shopping-list` folder and is built using Angular.
- **Back End**: The back end is located in the `shopping-spring` folder and is built using Spring Boot.

## Features

### Front End (Angular)

- View all shopping items
- Add new items to the shopping list
- Edit existing items
- Delete items from the list
- Filter items by category
- Mark items as purchased

### Back End (Spring Boot)

- RESTful API to manage shopping items
- CRUD operations for shopping items
- Endpoint to filter items by category
- Update purchased status of items

## Screenshots

![Screenshot 2024-10-29 172308](https://github.com/user-attachments/assets/dd53d941-cea0-45c2-820f-b931e3dbda1d)

![Screenshot 2024-10-29 172245](https://github.com/user-attachments/assets/d63f9f68-99fd-4088-a534-d5dc73f5e89f)


## Getting Started

### Prerequisites

- Node.js and npm (for the Angular front end)
- Java 11 or higher (for the Spring Boot back end)
- Maven (for building the Spring Boot application)
- An IDE (like IntelliJ IDEA, Eclipse, or Visual Studio Code)

### Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd <repository-name>
   ```

2. **Set up the front end**:
   ```bash
   cd shopping-list
   npm install
   ng serve
   ```
   The front end will be available at `http://localhost:4200`.

3. **Set up the back end**:
   ```bash
   cd shopping-spring
   mvn spring-boot:run
   ```
   The back end will be available at `http://localhost:8080`.

## API Endpoints

- **GET /api/shopping/items**: Retrieve all shopping items
- **GET /api/shopping/items/{id}**: Retrieve a shopping item by ID
- **POST /api/shopping/items**: Add a new shopping item
- **PUT /api/shopping/items/{id}**: Update an existing shopping item
- **DELETE /api/shopping/items/{id}**: Delete a shopping item
- **GET /api/shopping/items/category/{category}**: Retrieve items by category
- **PATCH /api/shopping/items/{id}/purchasedStatus**: Update the purchased status of an item

## Technologies Used

- **Front End**: Angular, TypeScript, HTML, CSS
- **Back End**: Spring Boot, Java, Maven, JPA, H2 Database

# GraphQL Books Project

A Spring Boot application demonstrating GraphQL integration with CRUD operations for authors and books.

## Key Components
- **DataLoader.java**: Handles efficient data fetching for GraphQL queries
- **GraphqlBooksApplication.java**: Main application class
- **Author/Book Models**: Domain objects with repository interfaces
- **graphql/ directory**: GraphQL schema and resolver definitions

## Technologies
- Spring Boot 3.x
- GraphQL (Spring GraphQL integration)
- Maven
- Docker (via docker-compose.yml)

## Getting Started
1. Build: `./mvnw clean package`
2. Run: `java -jar target/graphql-books-0.0.1-SNAPSHOT.jar`
3. Access GraphQL endpoint at `http://localhost:8080/graphql`

## Project Structure
```
graphql-books/
├── compose.yaml
├── docker-compose.yml
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │   ├── DataLoader.java
│   │   │   ├── GraphqlBooksApplication.java
│   │   │   ├── author/
│   │   │   │   └── Author.java
│   │   │   └── book/
│   │   │       └── Book.java
│   ├── resources/
│   │   └── application.yml
└── target/
```

## Contributing
Open issues or submit pull requests at [your-repo-url]
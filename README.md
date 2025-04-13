# Spring Boot Boilerplate Tomcat
Spring Boot Boilerplate for Spring Boot MicroService with Tomcat

### Prerequisites
- JDK v21
- Maven v3.9.6

### Build
- `setjdk21`
- `./mvnw clean package`
- `./mvnw clean test`

### Run
- `./mvnw spring-boot:run -Dspring-boot.run.profiles=dev`
- `./mvnw spring-boot:run -Dspring-boot.run.profiles=docker`

### Play
- http://localhost:8080/spring-boot-boilerplate-tomcat/v1/version

### Api documentation
- http://localhost:8080/spring-boot-boilerplate-tomcat/swagger-ui/index.html
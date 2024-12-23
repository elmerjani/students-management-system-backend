# Stage 1: Build Stage
FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar backend.jar
EXPOSE 8080
USER nonroot
ENTRYPOINT ["java", "-jar", "backend.jar"]

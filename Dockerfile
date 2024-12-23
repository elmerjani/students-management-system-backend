# Build stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

RUN addgroup --system javauser && adduser --system --ingroup javauser javauser
USER javauser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
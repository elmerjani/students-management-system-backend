# Utilisation de l'image de base OpenJDK
FROM openjdk:17-jdk-slim as build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR compilé dans le conteneur
COPY target/students-management-system-0.0.1-SNAPSHOT.jar /app/backend.jar

# Exposer le port utilisé par Spring Boot
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "backend.jar"]
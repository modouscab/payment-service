# Image Java
FROM eclipse-temurin:17-jdk-alpine

# Argument pour le jar
ARG JAR_FILE=target/*.jar

# Copier le jar
COPY ${JAR_FILE} app.jar

# Exposer le port
EXPOSE 8081

# Lancer l'application
ENTRYPOINT ["java","-jar","/app.jar"]
FROM maven:3.8.5-openjdk-18 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:18-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/sample-java-project-1.0.0.jar /app/sample-java-project.jar

ENTRYPOINT ["java", "-jar", "/app/sample-java-project.jar"]

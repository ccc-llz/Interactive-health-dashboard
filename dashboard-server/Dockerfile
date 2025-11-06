FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copy Project Files
COPY pom.xml .
COPY src src

# maven clear
RUN mvn clean package -DskipTests -B

# list files
RUN ls -la target/
RUN find target/ -name "*.jar" -type f

EXPOSE 8080

# boot up
CMD ["sh", "-c", "java -jar target/*.jar"]
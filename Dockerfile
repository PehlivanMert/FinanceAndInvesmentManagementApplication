# Base image
FROM openjdk:22-jdk-slim

# Maintainer info
LABEL maintainer="pehlivanmert@outlook.com.tr"

# Set the working directory
WORKDIR /app

# Copy the executable JAR file
COPY target/FinanceAndInvesmentManagementApplication.jar /app/FinanceAndInvesmentManagementApplication.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/FinanceAndInvesmentManagementApplication.jar"]

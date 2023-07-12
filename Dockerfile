#cmd : docker build -t offboarding-task-service .
FROM openjdk:8-jre-slim

ENV HOS=9.203.106.22
ENV IPDB=172.17.0.2
ENV CNF=173.17.0.5

# Set the working directory to /app
WORKDIR /app

# Copy the Eureka server JAR file to the container
COPY target/task-service.jar /app

# Expose the default Eureka server port
EXPOSE 9094

# Start the Eureka server
CMD ["java", "-jar", "task-service.jar"]
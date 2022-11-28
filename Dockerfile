#cmd : docker build -t onboarding-task-service .
FROM openjdk:8
EXPOSE 9094
ADD target/onboarding-task-service.jar onboarding-task-service.jar
ENTRYPOINT ["java","-jar","/onboarding-task-service.jar"]
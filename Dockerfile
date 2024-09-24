FROM openjdk:17-jdk-slim
ADD target/myfood_cqrs.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:8
ADD target/SpringApplication.jar SpringApplication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SpringApplication.jar"]
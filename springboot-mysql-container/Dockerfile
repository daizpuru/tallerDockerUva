FROM openjdk:8-jdk-alpine
VOLUME C:\tmp
COPY target/*.jar springboot-mysql.jar
ENTRYPOINT ["java","-jar","/springboot-mysql.jar"]
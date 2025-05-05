FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-springboot-swagger-openapi-squeleton-0.0.1-SNAPSHOT.jar gr-springboot-swagger-openapi-squeleton.jar
COPY target/gr-springboot-swagger-openapi-squeleton-0.0.1-SNAPSHOT.jar gr-springboot-swagger-openapi-squeleton-0.0.1-SNAPSHOT.jar
EXPOSE 1112
ENTRYPOINT ["java", "-jar", "gr-springboot-swagger-openapi-squeleton-0.0.1-SNAPSHOT.jar"]
FROM openjdk

ARG JAR_FILE=target/spring-boot-jobapp.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]

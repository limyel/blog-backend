FROM openjdk:8-jdk-alpine
ADD ./blog-api/target/blog-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar
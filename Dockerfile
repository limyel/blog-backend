FROM adoptopenjdk/openjdk11
ADD ./blog-web/target/blog-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar
FROM java:17
ADD ./target/blog-web-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar
FROM adoptopenjdk:17-jre-hotspot as builder
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests

FROM adoptopenjdk:17-jre-hotspot
ENV JAVA_HOME=/opt/java-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
COPY --from=builder /src/target/microservices-backend-*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app.jar"]





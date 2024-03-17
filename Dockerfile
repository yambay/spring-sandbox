# Build the image
FROM docker.io/library/eclipse-temurin:21-jdk as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Create a layered jar
FROM docker.io/library/eclipse-temurin:21-jdk
LABEL authors="Ilyas Yambay"
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib        /app/lib
COPY --from=build ${DEPENDENCY}/META-INF            /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes    /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","dev.yambay.springsandbox.SpringSandboxApplication"]

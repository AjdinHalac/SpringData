FROM openjdk:10-jre-slim
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
ARG BUILD_VERSION=dev-master
ARG ENVIRONMENT='staging'
ADD build/libs/com.bootcamp.spring-data-${BUILD_VERSION}.jar app/app.jar
ENV JAVA_OPTS='-XX:+UnlockExperimentalVMOptions'
ENV PROFILE=${ENVIRONMENT}
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar --spring.profiles.active=$PROFILE"]

FROM openjdk:8
WORKDIR /usr/src/myapp
ADD . /usr/src/myapp
RUN ./gradlew installDist
EXPOSE 4567

CMD ["build/install/counterservice/bin/counterservice"]


# Pull base image.
FROM ubuntu:latest

RUN \
    # Update
    apt-get update -y && \
    # Install Java
    apt-get install default-jre -y

ADD ./target/library-catalogue-0.0.1-SNAPSHOT.jar library-catalogue-0.0.1-SNAPSHOT

EXPOSE 8080

CMD java -jar library-catalogue-0.0.1-SNAPSHOT.jar
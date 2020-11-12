FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-discovery-1.0.0.jar xyz.jar
EXPOSE 5555
ENV BENIM_PARAM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${BENIM_PARAM} xyz.jar" ]
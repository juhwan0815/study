FROM openjdk:17-ea-11-slim
VOLUME /tmp
COPY build/libs/discoveryservice-0.1.jar DiscoveryService.jar
ENTRYPOINT ["java","-jar","DiscoveryService.jar"]
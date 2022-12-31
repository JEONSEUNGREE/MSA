FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/user-service-1.0.jar UserService.jar
ENTRYPOINT ["java", "-jar", "UserService.jar"]

# image create command
# docker build --tag acoursove2/user-service:1.0 .

# network
# 1. bridge network
# docker network create --driver bridge [name]

# 2. host network
# 3. none network

# docker network create --gateway 172.18.0.1 --subnet 172.18.0.0/16 ecommerce-network
FROM openjdk:8u332-oraclelinux7

ADD target/spring_boot_docker_example.jar spring_boot_docker_example.jar

ENTRYPOINT ["java","-jar","spring_boot_docker_example.jar"]

EXPOSE 8080
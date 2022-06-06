FROM openjdk:8u332-oraclelinux7

ADD target/spring_boot_docker_exa.jar spring_boot_docker_exa.jar

ENTRYPOINT ["java","-jar","spring_boot_docker_exa.jar"]

EXPOSE 8080
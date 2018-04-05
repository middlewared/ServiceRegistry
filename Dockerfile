FROM payara/micro
MAINTAINER Bartlomiej Kulig b.kulig@icloud.com
COPY ./target/PersistentServiceRegistry.war /opt/payara/deployments
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/deployments/PersistentServiceRegistry.war"]

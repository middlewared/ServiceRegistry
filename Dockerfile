FROM airhacks/glassfish
COPY ./target/PersistentServiceRegistry.war ${DEPLOYMENT_DIR}

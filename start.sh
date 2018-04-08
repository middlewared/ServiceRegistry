mvn clean package
docker stop PersistentServiceRegistry
docker rm PersistentServiceRegistry
docker build -t persistentserviceregistry:1.0 .
docker run -d -p 8080:8080 --name PersistentServiceRegistry persistentserviceregistry:1.0
docker logs -f PersistentServiceRegistry



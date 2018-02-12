#!/bin/sh
mvn clean package && docker build -t com.baku/PersistentServiceRegistry .
docker rm -f PersistentServiceRegistry || true && docker run -d -p 8080:8080 -p 4848:4848 --name PersistentServiceRegistry com.baku/PersistentServiceRegistry 

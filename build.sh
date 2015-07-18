#!/bin/bash
set -e
cd ~/Project/youbnb
mvn clean install
cd microservices
cd microservice-customer
mvn docker:build
cd ../microservice-auth
mvn docker:build
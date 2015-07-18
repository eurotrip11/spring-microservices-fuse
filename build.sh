#!/bin/bash
set -e
mvn clean install
cd microservices
cd microservice-customer
mvn docker:build
cd ../microservice-auth
mvn docker:build
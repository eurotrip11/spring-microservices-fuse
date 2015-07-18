#!/bin/bash
set -e
echo "Run Nexus docker"
docker pull sonatype/nexus
docker run -d -p 80:8081 --name nexus.local sonatype/nexus:oss
echo "Run Customer DB docker"
docker pull postgres
docker run --name customer.db -e POSTGRES_PASSWORD=customerdb -e POSTGRES_DB=customerdb -p 5432:5432 -d postgres
echo "Run Customer SERVICE docker"
docker run --name customer.service --link customer.db:postgres -p 8080:8080 -t -d youbnb/customer
echo "Run Auth SERVICE docker"
docker run --name auth.service --link customer.service:customer --link customer.db:postgres -p 8081:8081 -t -d youbnb/auth
echo "Run Jboss Fuse docker"
docker run -ti -p 8101:8101 -p 8181:8181 -d --name fuse.local --link nexus.local:nexus --link auth.service:auth --link customer.service:customer --link customer.db:postgres eurotrip11/jboss-fuse

echo "Run Api Man docker"
docker pull jboss/apiman-wildfly
docker run -it -p 9990:9990 -p 9080:9080 -d --name apiman.local --link fuse.local:jboss-fuse jboss/apiman-wildfly

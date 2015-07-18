#!/bin/bash
set -e
echo "Remove all containers"
docker ps -a | grep 'weeks ago' | awk '{print $1}' | xargs docker rm
#docker rm -v `docker ps -a -q -f status=exited`
#docker rmi $(docker images -q -f dangling=true)

#docker kill customer.db customer.service auth.service fuse.local nexus.local
docker rm -f customer.db customer.service auth.service fuse.local nexus.local

#!/bin/bash
set -e
echo "Remove all containers"
docker kill customer.db customer.service auth.service fuse.local apiman.local 
docker rm customer.db customer.service auth.service fuse.local apiman.local
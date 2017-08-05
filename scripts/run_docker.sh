#!/bin/bash
echo "Creating image"
if [ $# -ne 1 ];
    then echo "illegal number of parameters"
    exit 1
fi

BUILD_NUM=$1
echo "Running with BUILD_NUM=" $BUILD_NUM
docker build -t odedns/pet:$BUILD_NUM .
docker run -d --name t1  --rm -p 8888:8080 odedns/pet



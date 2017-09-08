@echo off

echo "Creating image"


if "%1"=="" echo "illegal number of parameters" && exit 

set BUILD_NUM=%1
echo "Running with BUILD_NUM=" %BUILD_NUM%

docker build -t odedns/pet:%BUILD_NUM% .

docker run -d --name t1  --rm -p 8888:8080 odedns/pet




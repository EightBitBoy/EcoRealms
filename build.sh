echo "###--- Starting the Docker build."
docker build -t eightbitboy/ecorealms .
docker ps -a
docker stop $(docker ps -a -q --filter ancestor=eightbitboy/ecorealms)
docker rm $(docker ps -a -q --filter ancestor=eightbitboy/ecorealms)
docker run -d eightbitboy/ecorealms
docker ps -a

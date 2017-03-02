echo "###--- Starting the Docker build."
docker build -t eightbitboy/ecorealms .
docker run -d eightbitboy/ecorealms
docker ps -a

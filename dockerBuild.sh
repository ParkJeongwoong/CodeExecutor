echo "Project Build"
./gradlew clean build -x test

echo "Docker Build"
  docker build --no-cache -t dvlprjw/codeExecutor .

echo "Docker Push"
docker push dvlprjw/codeExecutor

```bash

docker build -t m_paridarshan .
docker run -p 8080:8080 m_paridarshan

docker tag m_paridarshan:latest prasenjitdev/springboot-user:latest
docker push prasenjitdev/springboot-user:latest

git remote set-url origin git@github.com:prasenjit1011/NodeJSMongoDBMaster.git


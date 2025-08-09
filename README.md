

```bash
docker build -t springmaster .
docker run -p 8080:8080 springmaster

docker rm springboot-app
docker run -p 8080:8080 --name springboot-app --network host springmaster
docker run  --name springbootv2 --network my-net -p 8080:8080 springmaster


docker exec -it springboot-app hostname -I
docker run -d   --name postgres-db --network my-net -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=mydb -p 5432:5432  postgres:15


```

```bash
Check PostgreSQL DB connection status
http://localhost:8080/actuator/health
http://localhost:8080/db/test
```

```bash
Product Crud
http://localhost:8080/products
```




src
└── main
    ├── java
    │   └── com.example.productapp
    │       ├── controller
    │       ├── dto
    │       ├── exception
    │       ├── model
    │       ├── repository
    │       └── service
    └── resources
        └── application.yml
Dockerfile
docker-compose.yml
pom.xml



```bash
docker build -t springmaster .
docker run -p 8080:8080 springmaster

docker rm springboot-app
docker run -p 8080:8080 --name springboot-app --network host springmaster

docker exec -it postgres-dev psql -U myuser -d mydb

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


src/main/java/com/example/demo
│
├── controller
│   └── LocationController.java
├── service
│   └── LocationService.java
├── repository
│   ├── CountryRepository.java
│   ├── StateRepository.java
│   └── CityRepository.java
├── entity
│   ├── Country.java
│   ├── State.java
│   └── City.java
└── DemoApplication.java

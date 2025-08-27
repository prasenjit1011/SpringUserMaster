


docker build -t springmaster .
docker run -p 8080:8080 springmaster
docker run -p 8080:8080 --name springbootapp --network host springmaster
docker run -p 8080:8080 --name springbootapp springmaster


Check PostgreSQL DB connection status
http://localhost:8080/actuator/health
http://localhost:8080/db/test


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



DB_HOST1=10.5.48.161
DB_PORT1=5432
DB_DATABASE1=eportal_up
DB_USERNAME1=pbssm9
DB_PASSWORD1=P0$stgres33@



doskey /history > history01.txt
doskey /history
docker images -q
docker ps -a

docker run --name mydb3 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=testdb -p 5433:5432 -d postgres:15
-------------
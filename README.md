
```bash
# Postgre-SQL
## Step:01
docker run -d   --name postgres-db `
    --network my-net `
    -e POSTGRES_USER=postgres `
    -e POSTGRES_PASSWORD=postgres `
    -e POSTGRES_DB=mydb `
    -p 5432:5432 `
    -v C:\myprojects\github\postgres-data:/var/lib/postgresql/data postgres:17 



docker run -d --name sonarqube `
  -p 9000:9000 `
  -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true `
  sonarqube:community



## Step:02
docker network ls
docker network create my-net
docker start postgres-db
docker network connect my-net postgre-db


## Step:03
docker exec -it postgres-db psql -U postgres -d mydb


## PostgreSQL:Queries
CREATE DATABASE sonarqube;
CREATE USER postgres WITH ENCRYPTED PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE sonarqube TO postgres;


## PostgreSQL:Queries
CREATE TABLE products (id SERIAL PRIMARY KEY,  name VARCHAR(100) NOT NULL,  price DECIMAL(10,2) NOT NULL,  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO products (name, price) VALUES ('Laptop', 75000.00), ('Phone', 25000.00), ('Headphones', 3000.00);
SELECT * FROM products;


## Database:Show Tables
\dt


```


```bash

docker build -t springmaster .
docker run  --name springbootv25 --network my-net -p 8080:8080 springmaster



docker run -p 8080:8080 springmaster
docker rm springboot-app
docker run -p 8080:8080 --name springbootv3 --network host springmaster
docker run  --name springbootv25 --network my-net -p 8080:8080 springmaster
docker compose -f docker-compose.dev.yml up
docker exec -it springboot-app hostname -I
```

## docker-compose build
## docker-compose up
## docker-compose up --build


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



---------------------
```bash
🧹 Step 1: Stop all running containers
docker stop $(docker ps -q)

🧹 Step 2: Remove all containers
docker rm $(docker ps -aq)

🧹 Step 3: Remove all images
docker rmi -f $(docker images -q)

🧹 Step 4: Remove all volumes
docker volume rm $(docker volume ls -q)

🧹 Step 5: Remove all networks (except default ones)
docker network rm $(docker network ls -q)

🧹 Step 6: Clean up everything (one-shot)
docker system prune -a --volumes






PowerShell : 
docker ps -q | ForEach-Object { docker stop $_ }
docker ps -aq | ForEach-Object { docker stop $_; docker rm $_ }


docker images -q | ForEach-Object { docker rmi $_ -f }
docker volume ls -q | ForEach-Object { docker volume rm $_ }




docker network rm $(docker network ls -q)
docker system prune -a --volumes






```



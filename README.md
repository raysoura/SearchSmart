# SearchSmart
To make search smart and efficient

# 📝 Notes Search App (Spring Boot + Elasticsearch)

This is a simple Notes application built using **Spring Boot** and **Elasticsearch**. It allows users to:

- Add notes
- View all notes
- Search notes by keyword (across `title` and `body`)

---

## 📦 Requirements

- Java 17+
- Maven
- Docker (for running Elasticsearch)

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/notes-search-app.git
cd notes-search-app

### 2. Run Elasticsearch Locally

Create a docker-compose.yml with the following content:

version: '3.7'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.12.2
    container_name: elasticsearch
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
    ports:
      - "9200:9200"

### Start it using:
docker-compose up -d

### Verify it's running:
curl http://localhost:9200

### 3. Configure the Application
In src/main/resources/application.properties, ensure the following:

spring.elasticsearch.uris=http://localhost:9200
server.port=8080

### 4. Run the Application
Use Maven to build and run:
mvn spring-boot:run

The application will be available at:
📍 http://localhost:8080

APIs:

Add Notes

curl --location --request PUT 'http://localhost:8080/notes/' \
--header 'Content-Type: application/json' \
--data '{
    "id": "2",
    "title": "Souradeep",
    "content": "This is autobiograph"
}'

Get all Notes:

curl --location 'http://localhost:8080/notes/all'

Search Notes:

curl --location 'http://localhost:8080/notes/search?query=autobiograph'

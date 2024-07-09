# URL Shortener

### A simple URL shortener using Kotlin and Exposed.

#### How to run:

- Requirements:
    - Docker + Docker Compose
    - A database: PostgreSQL (currently work to support more databases)
    - Enviroment Variables
         ```shell
           PORT: ${PORT}
           HOST: ${HOST}
           DB_URL: "postgresql://db:5432/${POSTGRES_DB}"
           DB_USER: ${POSTGRES_USER}
           DB_PASSWORD: ${POSTGRES_PASSWORD}
         ```

- docker-compose.yml

```yaml
version: "3.8"

services:
  backend:
    image: ghcr.io/l3ktro/url-shortener:latest
    ports:
      - "${PORT}:${PORT}"
    environment:
      PORT: ${PORT}
      HOST: ${HOST}
      DB_URL: "postgresql://db:5432/${POSTGRES_DB}"
      DB_USER: ${POSTGRES_USER}
      DB_PASSWORD: ${POSTGRES_PASSWORD}
    depends_on:
      - db
  db:
    image: postgres:bullseye
    volumes:
      - postgres_data:/var/lib/postgresql/data
    environment:
      POSTGRES_DB: ${POSTGRES_DB}
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}

volumes:
  postgres_data:
```

- Run the following command:

```shell
docker-compose up
```


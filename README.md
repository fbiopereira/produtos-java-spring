# API PRODUTO

## Descrição

Exemplo de uma API rest utilizando as seguintes tecnologias:
- Java 17
- Spring
- Mongodb
- Prometheus
- Grafana


## Executando a API localmente

1 - Requisitos:
- Docker 4.10 + 
- Java 17 +
- Gradle 7.4.2 +

2 - Suba o Mongodb executando o arquivo ./docker/mongo-compose.yml no seu docker compose com o seguinte comando:
```
 docker-compose -f .\mongo-compose.yml up -d   
```

3- Configure as seguintes variáveis de ambiente no seu sistema operacional ou na sua IDE:
```
MONGO_DB_HOST=localhost
MONGO_DB_PORT=27017
MONGO_DB_USER=user
MONGO_DB_PWD=pwd
MONGO_DB_DATABASE=Loja-Demo
ENV=LOCAL
```

4- Execute a aplicação na sua IDE ou com o comando:
```
./gradlew bootRun
```

5- Abra as documentações da API

[SWAGGER](http://localhost:5001/doc/)

[ACTUATOR/MÉTRICAS](http://localhost:5002/actuator)

## Executando a API via Docker Compose

1 - Caso o Mongodb não esteja rodando, execute o arquivo ./docker/mongo-compose.yml no seu docker compose com o seguinte comando:
```
 docker-compose -f .\mongo-compose.yml up -d   
```

2 - Execute o arquivo ./docker/docker-compose.yml no seu docker compose com o seguinte comando:
```
 docker-compose -f .\docker-compose.yml up -d   
```

3- Abra as documentações da API

[SWAGGER](http://localhost:5001/doc/)

[ACTUATOR/MÉTRICAS](http://localhost:5002/actuator)

4- As métricas podem ser visualizadas no [PROMETHEUS](http://localhost:9090) ou no [GRAFANA](http://localhost:3000)
 - Você pode utilizar uma dashboard pronta, compatível com micrometer como [essa](https://grafana.com/grafana/dashboards/14430).
  
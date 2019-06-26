# Sample microservice skeleton

You can reffered this project as a skeletion to start microservice. This skeletion is created using jhipster which will bi-default give many production ready tool

## Getting Started

Please follow instruction to run it locally

### Prerequisites

Make sure you have install following tool

```
* jdk 8
* choco installer (if you uses windows. With the help **choco** you can install following tools)
* npm
* jhipster
* yarn
* docker
* mysql
```

### Run each microservice by following command


```
mvnw
```

### Dealing with Eureka server

If you get Eureka server error while running microservice then there are two option 1. disable Eureka client or 2. setup Eureka Server

#### Disable Eureka Client

Go to application.yml to every microservice and disable following properties


```
fetch-registry: false
register-with-eureka: false
```

#### Setting up Eureka Server on your local

Clone the following project from github and run using following command

```
git clone git@github.com:jhipster/jhipster-registry.git
mvnw
```

You can access Eureka server by using URL *http://localhost:8761/*

#### Swagger Implementation
Swagger is implemented in this POC. You can see swagger documentation about REST API for each microservice in two ways

```

1 on Jhipster-registry project --> API section.
2 use URL **[MICROSERVICE_SERVICE_URL]/v2/api-docs**

```


#### Health URL
You can check health of particular microservice in two ways

```

1 On Jhispter registry
2 using URL **[MICROSERVICE_SERVICE_URL]management/health**

```

#### Information about microservice profile
You can check info of particular microservice in two ways

```

1 On Jhispter registry
2 using URL **[MICROSERVICE_SERVICE_URL]management/info**

```

#### Note : for this microservice we used MYSQL DB(Need to make it already installed) with username root and no password


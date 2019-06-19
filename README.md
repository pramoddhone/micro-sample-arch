# Sample microservice skeleton

You can reffered this project as a skeletion to start microservice. This skeletion is created using jhipster which will bi-default give many production ready tool

## Getting Started

Please follow instruction to run it locally

### Prerequisites

Make sure you have install following tool

```
jdk 8
choco installer (if you uses windows. With the help *choco* you can install following tools)
npm
jhipster
yarn
docker
mysql
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

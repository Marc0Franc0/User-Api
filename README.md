# [User-Api](https://github.com/Marc0Franc0/User-Api#user-api)
Este proyecto demuestra la implementación de seguridad usando 
Spring Boot 3.0 y autenticación básica.

## Caracteísticas
- Registro de usuario e inicio de sesión con autenticación básica
- Cifrado de contraseña usando BCrypt
- Autorización basada en autoridades ("ADMIN","READ", "WRITE")

## Tecnologías
- Spring Boot 3.0
- Spring Security
- Basic Authentication
- BCrypt
- Maven

## Ejecución
1. Clonar repositorio: git clone https://github.com/Marc0Franc0/User-Api.git
2. Ir al directorio del proyecto: cd User-Api
3. Seguir pasos para ejecución con Docker o Maven

## Requerimientos para ejecutar con Docker

Para construir y ejecutar la aplicación necesita:
- [Docker](https://www.docker.com/products/docker-desktop/)

Ejecutar localmente

```shell
docker compose up
```

Dirigirse a: 
- [http://localhost:9090/](http://localhost:9090/)
- [http://localhost:9090/swagger-ui/index.html](http://localhost:9090/swagger-ui/index.html) 

## Requerimientos para ejecutar con Maven

Para construir y ejecutar la aplicación necesita:

- [JDK 20+](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3+](https://maven.apache.org)

Configurar datos de la base de datos MySQL: [application.properties](https://github.com/Marc0Franc0/User-Api/blob/main/src/main/resources/application.properties)

Configurar usuario admin: [application.properties](https://github.com/Marc0Franc0/User-Api/blob/main/src/main/resources/application.properties)
- data.username.admin = *****
- data.password.admin = *****

Ejecutar localmente

```shell
mvn clean install
```
```shell
mvn spring-boot:run
```

Dirigirse a:
- [http://localhost:8080/](http://localhost:8080/)
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) 
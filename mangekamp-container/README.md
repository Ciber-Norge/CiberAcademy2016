Spring Boot and ReactJS
-----------------------

Dette er selve programmet bygd med Spring Boot som controller og ReactJS som frontend.

## Hvordan kjøre programmet

### Lokalt

Kjør kommandoen `mvn package && java -jar target/gs-spring-boot-docker-0.1.0.jar` og gå til `http://localhost:8080/`.

### Lokalt med Docker
```
mvn package docker:build
sudo docker run -p 8080:8080 -t ciberacademy/ciber-mangekamp
```


## Mer informasjon
* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)
* [React.js and Spring Data REST](https://spring.io/guides/tutorials/react-and-spring-data-rest/)

## Ting som må gjøres:
* Legge til rette for at en bruker som ikke er logget inn kan se på sesong/event/resultatlister osv.
* Legge til ny sesong/fullføre innlegging av events.
* Vise alle events en user har deltatt i.
* Lage leaderboard.

# Fagdag Spring Boot

Denne er en kopi av Frode Johansen sitt fagdag repo. Som du finner på
[Github](https://github.com/frodejohansen/springboot).

Velkommen  til fagdag med : Spring Boot

Kodeeksemplene vil gi deg en liten 'speed intro' til hvordan du kan sette opp en Spring Boot
applikasjon og få den til å kommunisere med andre Spring Boot applikasjoner.

Eksemplene vil gi en introduksjon til flere av de små 'magiske' tingene Spring Boot kan gjøre
for deg sammenliknet med det 'klassiske' Spring-rammeverket.

## Oppgaver

- Ta en kikk på SpringBootNr1 & 2 & 3 for å få en forståelse av hvordan de er satt sammen.
- For å kunne teste 'SpringBootNr1' sin MongoDb funksjonalitet du å ha MongoDB kjørende
 - Du kan enten laste det ned og kjøre det lokalt
 - Eller du bruke Docker

### MongoDB i Docker

1. `docker run --name spring-boot-mongo -d mongo`
2. `docker inspect --format '{{ .NetworkSettings.IPAddress }}' spring-boot-mongo`
3. Lim IP'en inn i `springboot-tutorial/SpringBootNr1/src/main/resources/application.properties`
 * `spring.data.mongodb.host=<IP-adressen>`
4. Success?

Hvis du ønsker å utforske databasen din, så finnes det en Docker-image for det også!

1. `docker run -d -p 8008:80 --link spring-boot-mongo:db --name rockmongo webts/rockmongo`
2. Gå til `localhost:8008`

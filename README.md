# Ciber Academy 2016

Eksempel-repo for Ciber Academy 2016. I år fokuserer vi på Docker, Postgresql, Spring Boot, og ReactJS.

Vi kommer til å bruke tre forskjellige containere. En container for data (data-container), en for postgresql (postgresql-container), og en for Spring Boot og ReactJS (mangekamp-container).

## Hvordan kjøre
Hver container har en makefile som lar deg enkelt bygge, kjøre og stoppe containere.

* `make build`
* `make run`
* `make stop`
* `make clean`

## Requirements
* JDK 1.8 or later
* Maven 3.0 or later
* Docker 1.6.2 or later

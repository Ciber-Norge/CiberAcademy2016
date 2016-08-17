FROM alpine:3.4

RUN apk update && \
    apk upgrade && \
    apk add --no-cache postgresql

USER postgres
ENV LANG en_US.utf8
ENV PGDATA /var/lib/postgresql/data

EXPOSE 5432

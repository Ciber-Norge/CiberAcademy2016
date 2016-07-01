FROM alpine:3.4

RUN apk update && \
    apk upgrade && \
    apk add --no-cache postgresql

USER postgres
ENV LANG en_US.utf8
ENV PGDATA /var/lib/postgresql/data
RUN mkdir $PGDATA
#VOLUME /var/lib/postgresql/data

# initdb initializes a PostgreSQL database cluster.
#RUN initdb -D data
# a utility to initialize, start, stop, or control a PostgreSQL server.
#RUN pg_ctl start -D data


#COPY docker-entrypoint.sh /
#ENTRYPOINT ["/docker-entrypoint.sh"]

EXPOSE 5432
#CMD ["postgres"]

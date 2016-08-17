FROM alpine:3.4

RUN mkdir -p /var/lib/postgresql/data \
    && chown -R postgres:postgres /var/lib/postgresql/data
VOLUME /var/lib/postgresql/data

ENTRYPOINT ["/bin/echo", "Data-only container"]

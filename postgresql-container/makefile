IP := $(shell sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' postgres)
run:
	sudo docker run --volumes-from data --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=mangekamp -d kiasaki/alpine-postgres
stop:
	sudo docker stop postgres
start:
	sudo docker start postgres
clean:
	sudo docker rm postgres
ip:
	sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' postgres
populate:
	pg_restore --verbose --clean --no-acl --no-owner -h $(IP) -U postgres -d mangekamp mangekamp-db.backup

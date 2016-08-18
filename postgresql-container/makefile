run:
	sudo docker run --volumes-from data --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=mangekamp -d kiasaki/alpine-postgres
stop:
	sudo docker stop postgres
clean:
	sudo docker rm postgres
populate:
	#container-ip=`sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' postgres`
	#pg_restore --verbose --clean --no-acl --no-owner -h $(container-ip) -U postgres -d mangekamp mangekamp-db.backup

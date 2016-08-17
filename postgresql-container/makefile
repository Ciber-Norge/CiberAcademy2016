build:
	sudo docker build --tag postgresql .
run:
	sudo docker run --volumes-from data --name postgres -it --entrypoint=sh postgresql
clean:
	sudo docker rm postgres

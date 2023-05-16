local-env-create:
	docker-compose -f stack.yaml up -d
	sleep 3
	docker cp data/data.sql postgres_api_client:/var/lib/postgresql/data
	docker exec postgres_api_client psql -h localhost -U admin -d postgres -a -f ./var/lib/postgresql/data/data.sql

local-env-destroy:
	docker-compose -f stack.yaml down
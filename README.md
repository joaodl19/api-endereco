# api-endereco
API para consulta de CEP

1. Rodar a seguinte instrução para criação do container docker com postgres e tabela de logs:

- Acessar pasta do projeto;

- Executar o comando :sudo docker run --name postgres-container -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=stefanini -v ./database/CREATE_TABLE_LOGS.sql:/docker-entrypoint-initdb.d/init.sql -p 5433:5432 -d postgres



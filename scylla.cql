CREATE KEYSPACE livraria
WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' :3}
AND durable_writes = true;

use livraria;

CREATE TABLE livros(
    id uuid,
    nome text,
    nomeAutor text,
    anoDePublicacao text,
    PRIMARY KEY (id)
);
-- TABLE
CREATE TABLE pessoa(id INTEGER PRIMARY KEY autoincrement not null, nome VARCHAR(250) not null, email VARCHAR(250) not null, idade INTERGER not null, cp VARCHAR(250) not null, dataDeNascimento VARCHAR(250) not null);
CREATE TABLE produto(id INTEGER PRIMARY KEY autoincrement not null, nome VARCHAR(250) not null, preco DOUBLE not null, status BOOLEAN not null, quantidade INTERGER not null);
CREATE TABLE sqlite_sequence(name,seq);
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 

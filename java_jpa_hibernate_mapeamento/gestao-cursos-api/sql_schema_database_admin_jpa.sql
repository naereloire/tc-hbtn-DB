-- TABLE
CREATE TABLE ALUNO(id INTEGER PRIMARY KEY autoincrement not null, email VARCHAR(250) not null, matricula VARCHAR(250) not null, nascimento date not null, nomeCompleto VARCHAR(250) not null);
CREATE TABLE aluno_curso(curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE CURSO(id INTEGER PRIMARY KEY autoincrement not null, nome VARCHAR(250) not null, sigla VARCHAR(250) not null, materialCurso_id bigint not null, professor_id bigint not null, unique(materialCurso_id));
CREATE TABLE ENDERECO(id INTEGER PRIMARY KEY autoincrement not null, bairro VARCHAR(250) not null, cep interger not null, cidade VARCHAR(250), endereco VARCHAR(250), estado VARCHAR(250) not null, logradouro VARCHAR(250) not null, numero VARCHAR(250) not null );
CREATE TABLE MATERIALCURSO(id INTEGER PRIMARY KEY autoincrement not null, URL VARCHAR(250) not null);
CREATE TABLE PROFESSOR(id INTEGER PRIMARY KEY autoincrement not null, email VARCHAR(250) not null, matricula VARCHAR(250) not null, nomeCompleto VARCHAR(250) not null);
CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE TELEFONE(id INTEGER PRIMARY KEY autoincrement not null, ddd VARCHAR(250) not null, numero VARCHAR(250) not null);
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 

-- Database: TrabalhoFinal

-- DROP DATABASE "TrabalhoFinal";

CREATE DATABASE "TrabalhoFinal"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

create table Chale(
	codChale char(5) not null primary key,
	localizacao varchar(50) not null,
	capacidade int not null,
	valorAltaEstacao decimal(8,2),
	valorBaixaEstacao decimal(8,2)
);

create table Cliente(
	codCliente char(5) not null primary key,
	nomeCliente varchar(50) not null,
	rgCliente char(20) not null,
	enderecoCliente varchar(100),
	bairro varchar(40),
	cidadeCliente varchar(40) not null,
	estadoCliente varchar(40) not null,
	CEPCliente char(15) not null,
	nascimentoCliente date
);

create table Hospedagem(
	codChale char(5) not null,
	codHospedagem char(5) not null primary key,
	estado varchar(40) not null,
	dataInicio date not null,
	dataFim date not null,
	qtdPessoas int not null,
	desconto decimal(8,2),
	valorFinal decimal(8,2),
	constraint fk_Chale foreign key(codChale) references Chale(codChale)
);
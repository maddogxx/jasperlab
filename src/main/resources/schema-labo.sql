drop table if exists labo.tabela;
drop table if exists labo.coluna;

create table labo.tabela (
    codigo integer not null,
    nome varchar(255) not null, 
    esquema varchar(255) not null,
    primary key (codigo)
);

create table labo.coluna (
	codigo_tabela integer not null,
	codigo integer not null,
	nome varchar(255) not null,
	tipo varchar(255) not null,
	precisao int,
	tamanho int,
	eh_nulo varchar(255) not null,
	descricao varchar(255),
	primary key (codigo_tabela, codigo)
)
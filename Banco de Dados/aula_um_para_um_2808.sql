#Criação da base de dados 
CREATE DATABASE DB_UM_PARA_UM;

#Seleção do banco de dados
USE DB_UM_PARA_UM;

#Criação das tabelas
CREATE TABLE MARIDOS (
	id_marido INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, # INTEIRO, CHAVE PRIMÁRIA, NÃO PODER SER NULO, AUTO INCREMENTA
	nome_marido VARCHAR(40) NOT NULL,
	data_nasc_marido DATETIME #DATE: DATA | DATETIME: DATA E HORA
);

CREATE TABLE ESPOSAS (
	id_esposa INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_marido_fk INTEGER NOT NULL UNIQUE, # UNIQUE: 1 PARA 1 | PERMITIDO SÓ 1 UNICO ID_MARIDO
	nome_esposa VARCHAR(40) NOT NULL,
	data_nasc_esposa DATE,
	dt_casa_marido_esposa DATE NOT NULL,
	FOREIGN KEY(id_marido_fk) REFERENCES MARIDOS
    (id_marido) on update cascade on delete cascade
);

#Visualizar as tabelas criadas
describe maridos;
describe esposas;

#inserir registros  na tabela
insert into maridos(nome_marido,data_nasc_marido) values
('Leandro','1985-03-31'),
('João','1970-05-15'),
('José','1950-12-30');
#mostrar os registros dos maridos
select * from maridos;

insert into esposas(nome_esposa,data_nasc_esposa,
id_marido_fk,dt_casa_marido_esposa) values
('Carolina','1982-10-09','1','2007-06-09'),
('Maria','1973-06-18','2','2000-01-15'),
('Maricota','1955-07-21','3','1975-03-05');

#mostrar os registros das esposas
select * from esposas;

#inserir registro de esposa sem marido cadastrado
insert into esposas(nome_esposa,data_nasc_esposa,
id_marido_fk,dt_casa_marido_esposa) values
('Jo','1990-12-31','10','2010-01-20');

/*inserir registro de esposa com id de chave primária 
de marido duplicado*/
insert into esposas(nome_esposa,data_nasc_esposa,
id_marido_fk,dt_casa_marido_esposa) values
('Jo','1990-12-31','2','2010-01-20');

# listar maridos e esposas relacionando chave primária com 
# chave estrangeira
select dt_casa_marido_esposa,nome_esposa,
nome_marido from esposas,maridos
where id_marido_fk = id_marido;

# apagar chave primária garantindo o on delete cascade
delete from maridos
where id_marido = 3;


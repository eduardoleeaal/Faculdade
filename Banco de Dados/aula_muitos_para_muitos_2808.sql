#Criação do banco de dados
CREATE DATABASE BD_MUITOS_PARA_MUITOS;

#Seleção do banco
USE BD_MUITOS_PARA_MUITOS;

#Criação das tabelas
CREATE TABLE CLIENTES (
id_cli INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_cli VARCHAR(40) NOT NULL,
telefone_cli CHAR(14)
);

CREATE TABLE PRODUTOS (
id_prod INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome_prod VARCHAR(30) NOT NULL,
preco_prod FLOAT(8,2) NOT NULL 
);

CREATE TABLE COMPRAS (
id_compra INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_cli_fk INTEGER NOT NULL,
id_prod_fk INTEGER NOT NULL,
dt_compra DATETIME,
FOREIGN KEY(id_cli_fk) REFERENCES CLIENTES (id_cli)
 ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(id_prod_fk) REFERENCES PRODUTOS (id_prod)
 ON UPDATE CASCADE ON DELETE CASCADE
);

#inserção dos dados
insert into clientes (nome_cli,telefone_cli) VALUES
('Pedro','(41)99999-9999'),
('Tito','(24)98888-8888');
select * from clientes;

insert into produtos (nome_prod,preco_prod) VALUES
('teclado gamer',285.90),
('mouse gamer', 99.90),
('teclado simples',50.00),
('mouse simples',25.00);
select * from produtos;

insert into compras (id_cli_fk,id_prod_fk,dt_compra) VALUES
('1','4','2021-10-13 10:00'),
('1','3','2021-10-13 10:05');

#seleção dos dados das tabelas relacionadas
select id_compra,dt_compra,nome_cli,telefone_cli,nome_prod,preco_prod 
from compras,clientes,produtos
where (id_cli_fk = id_cli) and (id_prod_fk = id_prod);

# adicionando mais uma compra
insert into compras (id_cli_fk,id_prod_fk,dt_compra) VALUES
('2','2','2021-10-23 21:00'),
('2','1','2021-10-23 21:05');

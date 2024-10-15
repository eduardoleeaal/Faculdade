create database empresa;
use empresa;

CREATE TABLE clientes(
	id int NOT NULL AUTO_INCREMENT,
	nome varchar(40) NOT NULL,
    sexo enum('M', 'F'),
    nascimento DATE,
    cidade varchar(20) DEFAULT 'Curitiba',
    uf char(2) DEFAULT 'PR',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4;

INSERT INTO clientes(id, nome, sexo, nascimento, cidade, uf)
VALUES ('1', 'Ana', 'F', '1990-06-15', 'Curitiba', 'PR');

INSERT INTO clientes(id, nome, sexo, nascimento, cidade, uf)
VALUES ('2', 'Luiz', 'M', '1995-02-21', 'Colombo', 'PR');

INSERT INTO clientes VALUES
(default, 'Elaine', 'F', '1995-09-21', default, default),
(default, 'Fábio', 'M', '1995-10-22', 'Ponta Grossa', default),
(default, 'Gilberto', 'M', '1996-11-23', 'Santo André', 'SP');

INSERT INTO clientes(id, nome, sexo, nascimento, cidade, uf)
VALUES(default, 'Carlos', 'M', '1990-08-15', default, default);

INSERT INTO clientes (nome, sexo, nascimento, cidade, uf)
VALUES ('Henrique', 'M', null, 'Ortigueira', 'PR');

select * from clientes;

ALTER TABLE clientes DROP COLUMN nascimento;

ALTER TABLE clientes DROP COLUMN cidade;

ALTER TABLE clientes DROP COLUMN uf;

select * from clientes;

ALTER TABLE clientes ADD COLUMN peso float;

ALTER TABLE clientes ADD COLUMN  idade tinyint unsigned;

ALTER TABLE clientes ADD COLUMN bairro varchar(15);

ALTER TABLE clientes ADD COLUMN celular varchar(11) NOT NULL;

UPDATE clientes SET
	idade = 20,
    peso = 56.3,
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 1;

UPDATE clientes SET
	idade = 20,
    peso = 56.3,
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 2;

UPDATE clientes SET
	idade = '20',
    peso = '56.3',
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 3;

UPDATE clientes SET
	idade = '20',
    peso = '56.3',
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 4;

UPDATE clientes SET
	idade = '20',
    peso = '56.3',
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 5;

UPDATE clientes SET
	idade = '20',
    peso = '56.3',
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 6;

UPDATE clientes SET
	idade = '20',
    peso = '56.3',
    bairro = 'Fazendinha',
    celular = '99999-1111'
WHERE id = 7;

select * from clientes;

create table produtos(
	id int NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    estoque int NOT NULL,
    preco float NOT NULL,
    funcionario varchar(51) NOT NULL,
    observacao varchar(201),
    PRIMARY KEY(id)
) DEFAULT CHARSET = utf8mb4;

INSERT INTO produtos VALUES
(default, 'Sabao em po', '100', '9', 'Alcir Jr.', null),
(default, 'Sabao em barra', '277', '4.5', 'Maria Rita Amorim', 'Algumas Barras estão avariadas'),
(default, 'Vanish em po 1kg', '70', '45', 'Alcir Jr.', null);

select * from produtos;

drop table produtos;
#Criação do banco de dados
CREATE DATABASE DB_UM_PARA_MUITOS;

#Seleção do banco 
USE DB_UM_PARA_MUITOS;

#Criação das tabelas
CREATE TABLE FUNCIONARIOS (
id_func INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
cpf_func CHAR(14) NOT NULL,
nome_func VARCHAR(40) NOT NULL,
cargo_func VARCHAR(15) NOT NULL,
salario_func FLOAT(8,2) NOT NULL,
dt_admissao_func DATE NOT NULL,
dt_demissao_func DATE,
dt_nasc_func DATE NOT NULL
);

CREATE TABLE DEPENDENTES (
id_dep INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_func_fk INTEGER,
nome_dep VARCHAR(40),
parentesco_dep VARCHAR(10),
dt_nasc_dep DATE,
FOREIGN KEY(id_func_fk) REFERENCES 
FUNCIONARIOS (id_func) on update cascade on delete cascade
);

# Inserção de dados nas tabelas
insert into funcionarios 
(cpf_func,nome_func,cargo_func,salario_func,
dt_admissao_func,dt_nasc_func) VALUES
('123.456.789-00','João','Operador I',
1500.00,'2020-01-02','1998-10-05'),
('321.654.987-99','José','Líder',
3500.00,'2010-03-10','1988-02-15');

insert into funcionarios 
(cpf_func,nome_func,cargo_func,salario_func,
dt_admissao_func,dt_nasc_func) VALUES
('987.654.321-22','Maria','Gerente',
9000.00,'2009-05-20','1995-11-19');

#listar os funcionários
select * from funcionarios;

# Inserir dependentes
insert into dependentes 
(nome_dep,parentesco_dep,dt_nasc_dep,id_func_fk) VALUES
('Leandro','Filho','2019-03-31','1'),
('Adilson','Filho','2020-02-19','1'),
('Nilza','Esposa','1999-04-05','1');

#Inserir deoendente da nova funcionária
insert into dependentes 
(nome_dep,parentesco_dep,dt_nasc_dep,id_func_fk) VALUES
('Marcos','Marido','1997-10-02','3');

# Listar os dependentes relacionando com os funcionáriops
select dt_nasc_dep,nome_dep,parentesco_dep,nome_func,cargo_func
from dependentes,funcionarios where id_func_fk = id_func;

# Alterar o id para verificar a alteração da dependência
# de chve primária como estrangeira
update funcionarios
set id_func = '4'
where id_func = '1';

#Inserir novos funcionários parta verificar o auto increment
insert into funcionarios 
(cpf_func,nome_func,cargo_func,salario_func,
dt_admissao_func,dt_nasc_func) VALUES
('123.456.789-10','Cleiton','Operador II',
1500.00,'2020-01-02','1998-10-05'),
('321.654.987-99','Humberto','Líder',
3500.00,'2010-03-10','1988-02-15');

#Inserir novos dependentes para verificar a dependência da chave 
#estrangeira e duplicação de registros 
insert into dependentes 
(nome_dep,parentesco_dep,dt_nasc_dep,id_func_fk) VALUES
('Leonardo','Filho','2019-03-31','5'),
('Ademilson','Filho','2020-02-19','5'),
('Nila','Esposa','1999-04-05','5'),
('Leonardo','Filho','2019-03-31','5'),
('Ademilson','Filho','2020-02-19','5'),
('Nila','Esposa','1999-04-05','5'),
('Leonardo','Filho','2019-03-31','5'),
('Ademilson','Filho','2020-02-19','5'),
('Nila','Esposa','1999-04-05','5');


#listar funcionários
select * from funcionarios;

#listar funcionários com dependentes duplicados
select dt_nasc_dep,nome_dep,parentesco_dep,nome_func,cargo_func
from dependentes,funcionarios where id_func_fk = id_func;

#apagar funcionários copm dependentes duplicados
delete from funcionarios
where id_func = '5';

select * from dependentes;

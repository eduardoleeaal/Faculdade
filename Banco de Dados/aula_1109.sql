create database HotelSaintGermain;
use hotelsaintgermain;

CREATE TABLE Cliente (
Id INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(100) NOT NULL,
CPF VARCHAR(11) UNIQUE NOT NULL,
DtaCadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
Cidade VARCHAR(20) NOT NULL,
Uf CHAR(2) NOT NULL DEFAULT 'PR',
Pais VARCHAR(20) NOT NULL DEFAULT 'Brasil'
);

CREATE TABLE Reserva (
    NroReserva INT PRIMARY KEY,
    ClientId INT,
    Entrada DATETIME NOT NULL,
    Periodo TINYINT NOT NULL,
    FOREIGN KEY (ClientId)
        REFERENCES Cliente (Id)
);

CREATE TABLE Telefone (
    Numero VARCHAR(20),
    ClientId INT,
    PRIMARY KEY (Numero , ClientId),
    FOREIGN KEY (ClientId)
        REFERENCES Cliente (Id)
);
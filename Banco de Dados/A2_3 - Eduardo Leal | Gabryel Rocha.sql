-- EDUARDO LEAL & GABRYEL ROCHA
-- COMANDOS PARA CRIAÇÃO DO BANCO DE DADOS E TABELAS
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30)
);

CREATE TABLE livros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50),
    autor VARCHAR(50),
    anoPubli DATE,
    numExemplares INT,
    categoria INT,
    FOREIGN KEY (categoria) REFERENCES categorias (id)
);

CREATE TABLE autores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);

CREATE TABLE membros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    endereco VARCHAR(100)
);

CREATE TABLE emprestimos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    membroID INT,
    livroID INT,
    dataEmprestimo DATE,
    dataDevolucaoPrev DATE,
    dataDevolucaoReal DATE,
    FOREIGN KEY (membroID) REFERENCES membros (id),
    FOREIGN KEY (livroID) REFERENCES livros (id)
);

-- COMANDOS DA QUESTÃO 1:
-- Listar o título do livro e o nome do autor para todos os livros cadastrados na base.
SELECT titulo, autor FROM livros;

-- COMANDOS DA QUESTÃO 2:
-- Listar a data de empréstimo, o nome do membro que emprestou, e o título do livro de todos os empréstimos feitos neste ano.
SELECT e.dataEmprestimo, m.nome, l.titulo
FROM emprestimos e
JOIN membros m ON e.membroID = m.id
JOIN livros l ON e.livroID = l.id
WHERE YEAR(e.dataEmprestimo) = YEAR(CURDATE());

-- COMANDOS DA QUESTÃO 3:
-- Listar o nome da categoria e o título do livro de todos os livros cadastrados na base.
SELECT c.nome AS categoria, l.titulo
FROM livros l
JOIN categorias c ON l.categoria = c.id;

-- COMANDOS DA QUESTÃO 4:
-- Listar o título do livro, a data de empréstimo e a data da devolução real de todos os livros da base.
SELECT l.titulo, e.dataEmprestimo, e.dataDevolucaoReal
FROM emprestimos e
JOIN livros l ON e.livroID = l.id;

-- COMANDOS DA QUESTÃO 5:
-- Listar a data de empréstimo, data da devolução real, nome do membro que emprestou, título do livro, nome da categoria e nome do autor (ou autores) de todos os empréstimos realizados.
SELECT e.dataEmprestimo, e.dataDevolucaoReal, m.nome AS membro, l.titulo, c.nome AS categoria, l.autor
FROM emprestimos e
JOIN membros m ON e.membroID = m.id
JOIN livros l ON e.livroID = l.id
JOIN categorias c ON l.categoria = c.id;

-- COMANDOS DA QUESTÃO 6:
-- Contar quantos livros estão cadastrados na base.
SELECT COUNT(*) AS total_livros FROM livros;

-- COMANDOS DA QUESTÃO 7:
-- Contar quantos empréstimos foram feitos no ano passado.
SELECT COUNT(*) AS total_emprestimos
FROM emprestimos
WHERE YEAR(dataEmprestimo) = YEAR(CURDATE()) - 1;

-- COMANDOS DA QUESTÃO 8:
-- Listar o nome da categoria e a quantidade de livros por categoria.
SELECT c.nome AS categoria, COUNT(l.id) AS quantidade_livros
FROM categorias c
LEFT JOIN livros l ON c.id = l.categoria
GROUP BY c.nome;

-- COMANDOS DA QUESTÃO 9:
-- Listar o título do livro e o nome do membro de todos os livros emprestados na semana corrente, agrupados e ordenados por data de empréstimo.
SELECT l.titulo, m.nome, e.dataEmprestimo
FROM emprestimos e
JOIN membros m ON e.membroID = m.id
JOIN livros l ON e.livroID = l.id
WHERE YEARWEEK(e.dataEmprestimo, 1) = YEARWEEK(CURDATE(), 1)
ORDER BY e.dataEmprestimo;

-- COMANDOS DA QUESTÃO 10:
-- Listar o total de livros emprestados no ano atual, agrupados e ordenados cronologicamente por mês, sendo que o nome do mês deve ser apresentado por extenso.
SELECT MONTHNAME(dataEmprestimo) AS mes, COUNT(*) AS total_emprestados
FROM emprestimos
WHERE YEAR(dataEmprestimo) = YEAR(CURDATE())
GROUP BY MONTH(dataEmprestimo), MONTHNAME(dataEmprestimo)
ORDER BY MONTH(dataEmprestimo);




-- Inserindo categorias
INSERT INTO categorias (nome) VALUES 
('Ficção'),
('Não-ficção'),
('Fantasia'),
('Biografia'),
('História');

-- Inserindo livros
INSERT INTO livros (titulo, autor, anoPubli, numExemplares, categoria) VALUES 
('O Senhor dos Anéis', 'J.R.R. Tolkien', '1954-07-29', 5, 3),
('1984', 'George Orwell', '1949-06-08', 3, 1),
('A Revolução dos Bichos', 'George Orwell', '1945-08-17', 4, 1),
('O Diário de Anne Frank', 'Anne Frank', '1947-06-25', 2, 4),
('Sapiens: Uma Breve História da Humanidade', 'Yuval Noah Harari', '2011-01-01', 6, 2);

-- Inserindo membros
INSERT INTO membros (nome, endereco) VALUES 
('João Silva', 'Rua A, 123'),
('Maria Oliveira', 'Avenida B, 456'),
('Carlos Pereira', 'Praça C, 789'),
('Ana Costa', 'Rua D, 101');

-- Inserindo empréstimos
INSERT INTO emprestimos (membroID, livroID, dataEmprestimo, dataDevolucaoPrev, dataDevolucaoReal) VALUES 
(1, 1, '2023-01-10', '2023-01-17', '2023-01-15'),
(2, 2, '2024-02-05', '2024-02-12', NULL),
(3, 3, '2024-11-12', '2024-12-12', '2025-01-05'),
(1, 4, '2024-03-15', '2024-03-22', '2024-03-20'),
(4, 5, '2023-04-01', '2023-04-08', NULL);
CREATE DATABASE IF NOT EXISTS EPIGerenciamento;
USE EPIGerenciamento;

-- Tabela Cargo
CREATE TABLE Cargo (
    idCargo INT AUTO_INCREMENT PRIMARY KEY,
    NomeCargo VARCHAR(45) NOT NULL
);

-- Tabela Funcionario
CREATE TABLE Funcionario (
    idFuncionario INT AUTO_INCREMENT PRIMARY KEY,
    NomeFuncionario VARCHAR(45) NOT NULL,
    Sobrenome VARCHAR(45) NOT NULL,
    Cargo_idCargo INT,
    FOREIGN KEY (Cargo_idCargo) REFERENCES Cargo(idCargo)
);

-- Tabela Marca
CREATE TABLE Marca (
    idMarca INT AUTO_INCREMENT PRIMARY KEY,
    NomeMarca VARCHAR(45) NOT NULL
);

-- Tabela Tipo
CREATE TABLE Tipo (
    idTipo INT AUTO_INCREMENT PRIMARY KEY,
    NomeTipo VARCHAR(45) NOT NULL
);

-- Tabela EPI
CREATE TABLE EPI (
    idEPI INT AUTO_INCREMENT PRIMARY KEY,
    NomeEPI VARCHAR(45) NOT NULL,
    Validade DATE,
    CA INT,
    Descricao VARCHAR(100),
    Marca_idMarca INT,
    Quantidade INT,
    Tipo_idTipo INT,
    FOREIGN KEY (Marca_idMarca) REFERENCES Marca(idMarca),
    FOREIGN KEY (Tipo_idTipo) REFERENCES Tipo(idTipo)
);

-- Tabela Entrega_Troca_Devolucao
CREATE TABLE Entrega_Troca_Devolucao (
    idEntrega_Troca_Devolucao INT AUTO_INCREMENT PRIMARY KEY,
    Funcionario_idFuncionario INT,
    EPI_idEPI INT,
    Quantidade_entregue INT,
    data_entrega DATE,
    Hora_entrega TIME,
    FOREIGN KEY (Funcionario_idFuncionario) REFERENCES Funcionario(idFuncionario),
    FOREIGN KEY (EPI_idEPI) REFERENCES EPI(idEPI)
);

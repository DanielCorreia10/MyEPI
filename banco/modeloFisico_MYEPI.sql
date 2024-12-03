CREATE DATABASE IF NOT EXISTS MyEPI_DB;
USE MyEPI_DB;

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
	CONSTRAINT FK_Cargo_Funcionario 
    FOREIGN KEY (Cargo_idCargo) REFERENCES Cargo(idCargo)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
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
    Validade DATE NOT NULL,
    CA INT NOT NULL,
    Descricao VARCHAR(100),
    Quantidade INT NOT NULL,
    Marca_idMarca INT,
    Tipo_idTipo INT,
    CONSTRAINT FK_Marca_Epi FOREIGN KEY (Marca_idMarca) REFERENCES Marca(idMarca)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
    CONSTRAINT FK_Tipo_Epi FOREIGN KEY (Tipo_idTipo) REFERENCES Tipo(idTipo)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

-- Tabela Entrega_Troca_Devolucao
CREATE TABLE Entrega_Troca_Devolucao (
    idEntrega_Troca_Devolucao INT AUTO_INCREMENT PRIMARY KEY,
    Quantidade_entregue INT NOT NULL,
    data_entrega DATE NOT NULL,
    Hora_entrega TIME NOT NULL,
    Funcionario_idFuncionario INT,
    EPI_idEPI INT,
    CONSTRAINT FK_Funcionario_Entrega FOREIGN KEY (Funcionario_idFuncionario) REFERENCES Funcionario(idFuncionario)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    CONSTRAINT FK_Epi_Entrega FOREIGN KEY (EPI_idEPI) REFERENCES EPI(idEPI)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

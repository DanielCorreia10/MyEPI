CREATE DATABASE IF NOT EXISTS MyEPI_BD;
USE MyEPI_BD;

-- Tabela Cargo
CREATE TABLE Cargo (
    idCargo INT AUTO_INCREMENT PRIMARY KEY,
    nomeCargo VARCHAR(45) NOT NULL
);

-- Tabela Funcionario
CREATE TABLE Funcionario (
    idFuncionario INT AUTO_INCREMENT PRIMARY KEY,
    nomeFuncionario VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    cargo_idCargo INT,
	CONSTRAINT FK_Cargo_Funcionario 
    FOREIGN KEY (cargo_idCargo) REFERENCES Cargo(idCargo)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

-- Tabela Marca
CREATE TABLE Marca (
    idMarca INT AUTO_INCREMENT PRIMARY KEY,
    nomeMarca VARCHAR(45) NOT NULL
);

-- Tabela Tipo
CREATE TABLE Tipo (
    idTipo INT AUTO_INCREMENT PRIMARY KEY,
    nomeTipo VARCHAR(45) NOT NULL
);

-- Tabela EPI
CREATE TABLE EPI (
    idEpi INT AUTO_INCREMENT PRIMARY KEY,
    NomeEpi VARCHAR(45) NOT NULL,
    validade DATE NOT NULL,
    ca INT NOT NULL,
    descricao VARCHAR(100),
    quantidade INT NOT NULL,
    marca_idMarca INT,
    tipo_idTipo INT,
    CONSTRAINT FK_Marca_Epi FOREIGN KEY (marca_idMarca) REFERENCES Marca(idMarca)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
    CONSTRAINT FK_Tipo_Epi FOREIGN KEY (tipo_idTipo) REFERENCES Tipo(idTipo)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

-- Tabela Entrega_Troca_Devolucao
CREATE TABLE Entrega_Troca_Devolucao (
    idEntrega INT AUTO_INCREMENT PRIMARY KEY,
    quantidade_entregue INT NOT NULL,
    data_entrega DATE NOT NULL,
    hora_entrega TIME NOT NULL,
    funcionario_idFuncionario INT,
    epi_idEpi INT,
    CONSTRAINT FK_Funcionario_Entrega FOREIGN KEY (funcionario_idFuncionario) REFERENCES Funcionario(idFuncionario)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    CONSTRAINT FK_Epi_Entrega FOREIGN KEY (epi_idEpi) REFERENCES EPI(idEPI)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

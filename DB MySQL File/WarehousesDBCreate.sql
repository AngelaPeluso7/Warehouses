DROP DATABASE IF EXISTS Warehouses;

CREATE DATABASE Warehouses
	DEFAULT CHARACTER SET latin1
    DEFAULT COLLATE latin1_general_ci;

USE Warehouses;

DROP TABLE IF EXISTS Warehouse;

CREATE TABLE Warehouse(
	idWarehouse INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	maxSize INT(11) NOT NULL
);
    
DROP TABLE IF EXISTS Inventory;
    
CREATE TABLE Inventory(
    typeProduct VARCHAR(45) PRIMARY KEY,
    idWarehouse INT(11) NOT NULL,
    quantity INT(11) NOT NULL,
	FOREIGN KEY (idWarehouse) REFERENCES Warehouse(idWarehouse)
);
    
DROP TABLE IF EXISTS Consignement;

CREATE TABLE Consignement(
	idConsignement INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idWarehouse INT(11) NOT NULL,
    typeProduct VARCHAR(45),
	state VARCHAR(45),
    FOREIGN KEY (idWarehouse) REFERENCES Inventory(idWarehouse)
);
DROP TABLE IF EXISTS Orders;

CREATE TABLE Orders(
	idOrder INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	typeProduct1 VARCHAR(45) NOT NULL,
    idConsignement1 INT(11) NOT NULL,
    typeProduct2 VARCHAR(45) NOT NULL,
    idConsignement2 INT(11) NOT NULL,
    FOREIGN KEY (idConsignement1) REFERENCES Consignement(idConsignement),
    FOREIGN KEY (idConsignement2) REFERENCES Consignement(idConsignement)
);
    
DROP TABLE IF EXISTS Invoice;

CREATE TABLE Invoice(
	idInvoice INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idOrder INT(11) NOT NULL,
	state VARCHAR(45) NOT NULL,
    FOREIGN KEY (idOrder) REFERENCES Orders(idOrder)
);
    

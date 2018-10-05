# jdbc-transaction-example
Example of using Transactions with Prepared Statements in JDBC by MySQL

Firstly add configuration parameters in config class, and execute create query in your db:

CREATE TABLE Owner
(
    Id INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Dog
(
    Id INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    OwnerId int NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (OwnerId) REFERENCES Owner(Id)
);

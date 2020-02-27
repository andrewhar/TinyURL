drop database urlShortenDB;

create database URLShortenDB;
use URLShortenDB;

create table UserTable (
	UserId int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(UserId)
);


create table URLTable (
	URLId int NOT NULL AUTO_INCREMENT UNIQUE,
    CreatedDate datetime NOT NULL,
    UserId int NOT NULL,
    PRIMARY KEY (URLId),
    CONSTRAINT url_fk FOREIGN KEY (UserId) REFERENCES UserTable(UserId) 
);

create table OrgURLTable (
	URLId int NOT NULL,
    OrgURL varchar(255) NOT NULL,
    CONSTRAINT org_url_pk PRIMARY KEY (URLId),
    CONSTRAINT org_url_fk FOREIGN KEY (URLId) REFERENCES URLTable(URLId)
);

create table TinyURLTable (
	URLId int NOT NULL,
    TinyURL varchar(255) NOT NULL,
    CONSTRAINT tiny_url_pk PRIMARY KEY (URLId),
    CONSTRAINT tiny_url_fk FOREIGN KEY (URLId) REFERENCES URLTable(URLId) 
)
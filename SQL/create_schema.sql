drop database urlShortenDB;

create database URLShortenDB;
use URLShortenDB;

create table user (
	user_id int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(user_id)
);


create table url (
	url_id int NOT NULL AUTO_INCREMENT UNIQUE,
    created_date datetime NOT NULL,
    user_id int,
    PRIMARY KEY (url_id),
    CONSTRAINT url_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);

create table org_url(
	url_id int NOT NULL,
    org_url varchar(255) NOT NULL,
    CONSTRAINT org_url_pk PRIMARY KEY (url_id),
    CONSTRAINT org_url_fk FOREIGN KEY (url_id) REFERENCES url(url_id) ON DELETE CASCADE
);

create table tiny_url (
	url_id int NOT NULL,
    tiny_url varchar(255) NOT NULL,
    CONSTRAINT tiny_url_pk PRIMARY KEY (url_id),
    CONSTRAINT tiny_url_fk FOREIGN KEY (url_id) REFERENCES url(url_id) ON DELETE CASCADE
)
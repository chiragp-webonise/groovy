--liquibase formatted sql

--changeset salerno:3
create table task (
    id int primary key AUTO_INCREMENT,
    description varchar(255)
);

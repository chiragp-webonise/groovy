--liquibase formatted sql

--changeset salerno:4
insert into task (id, description) values (1, 'Get book from library');
insert into task (id, description) values (2, 'Deposit money into bank');
insert into task (id, description) values (3, 'Gym at 7 AM');
insert into task (id, description) values (4, 'Reach office at 11 AM');
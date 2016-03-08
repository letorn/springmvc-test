create database if not exists springmvc_test;
use springmvc_test;

create table if not exists user(
  id int primary key auto_increment,
  name varchar(15) not null,
  birth date
);
insert into user(id, name, birth) values(1, 'admin', '1990-06-10');
insert into user(id, name, birth) values(2, 'admin', '1990-06-10');
insert into user(id, name, birth) values(3, 'admin', '1990-06-10');
insert into user(id, name, birth) values(4, 'admin', '1990-06-10');
insert into user(id, name, birth) values(5, 'admin', '1990-06-10');


create table if not exists account(
  id int primary key auto_increment,
  name varchar(15) not null,
  password varchar(25) not null
);
insert into account(id, name, password) values(1, 'admin', 'admin');
insert into account(id, name, password) values(2, 'admin', 'admin');
insert into account(id, name, password) values(3, 'admin', 'admin');
insert into account(id, name, password) values(4, 'admin', 'admin');
insert into account(id, name, password) values(5, 'admin', 'admin');
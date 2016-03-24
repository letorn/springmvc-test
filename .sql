create database if not exists springmvc_test;
use springmvc_test;

drop table if exists account;
create table if not exists account(
  id int primary key auto_increment,
  name varchar(15) not null,
  password varchar(25) not null,
  user_id int not null
);
insert into account(id, name, password, user_id) values(1, 'admin', 'admin', 1);
insert into account(id, name, password, user_id) values(2, 'admin', 'admin', 2);
insert into account(id, name, password, user_id) values(3, 'admin', 'admin', 3);
insert into account(id, name, password, user_id) values(4, 'admin', 'admin', 4);
insert into account(id, name, password, user_id) values(5, 'admin', 'admin', 5);


drop table if exists user;
create table if not exists user(
  id int primary key auto_increment,
  name varchar(15) not null,
  birth date,
  role_id int not null
);
insert into user(id, name, birth, role_id) values(1, 'user1', '1990-06-01', 1);
insert into user(id, name, birth, role_id) values(2, 'user2', '1990-06-02', 2);
insert into user(id, name, birth, role_id) values(3, 'user3', '1990-06-03', 2);
insert into user(id, name, birth, role_id) values(4, 'user4', '1990-06-04', 3);
insert into user(id, name, birth, role_id) values(5, 'user5', '1990-06-05', 3);


drop table if exists role;
create table if not exists role(
  id int primary key auto_increment,
  name varchar(15) not null
);
insert into role(id, name) values(1, 'admin');
insert into role(id, name) values(2, 'manager');
insert into role(id, name) values(3, 'guest');
create database bai1;
use bai1;
#cu phap tao khoa chinh
Create table users(
user_id int auto_increment primary key,
username varchar(40),
password varchar(255),
email varchar(255));
create table roles(
role_id int auto_increment,
role_name varchar(50),
primary key(role_id));
#to hop khoa to hop
create table usertoles(
user_id int not null,
role_id int not null,
primary key(user_id,role_id),
foreign key(user_id) references users(user_id),
foreign key(role_id) references roles(role_id));
#sua khoa
ALTER TABLE table_name
    ADD PRIMARY KEY(primary_key_column);

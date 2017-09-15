--创建数据库--
create database foretaste;
use foretaste
--创建用户表--
create table user_info(id int(11) not null primary key auto_increment,
 nickname varchar(50) not null, phone_num char(11) not null, 
 created_time timestamp not null default current_timestamp, 
 last_update_time timestamp not null default current_timestamp);
--创建账户表--
create table account(account_id int not null primary key auto_increment,
user_id int not null comment '用户ID',
money decimal(10,2) not null comment '余额' ,
UNIQUE INDEX  (user_id));
create database testlogin;
go

use testlogin;
go

create table accounts(
	username varchar(20) primary key,
	pass varchar(20) not null,
	fullname varchar(50)
);

select * from accounts;
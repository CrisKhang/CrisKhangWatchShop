

USE MASTER
GO

drop database PS15054_TranGiaKhang_ASM_JAVA4
go

create database  PS15054_TranGiaKhang_ASM_JAVA4
GO

use  PS15054_TranGiaKhang_ASM_JAVA4
go


create table Users
(
	id varchar(20) primary key,
	password varchar(50),
	email varchar(50),
	fullname nvarchar(50),
	admin bit
)
go

create table Video
(
	id varchar(20) primary key,
	Title nvarchar(50),
	Poster varchar(50),
	views int,
	Description nvarchar(500),
	Price varchar(50),
	Active bit
)
go

create table Favorite
(
	id int identity(1,1) primary key,
	UserID varchar(20) references Users(id),
	VideoID varchar(20) references Video(id),
	LikeDate date
)
go

create table Share
(
	id int identity(1,1) primary key,
	UserID varchar(20) references Users(id),
	VideoID varchar(20) references Video(id),
	Email varchar(50),
	ShareDate date
)
go


insert into Users values 
('khang','123','khangfpt.edu.vn',N'Trần Gia Khang',0)
go

insert into Video values
('1',N'Heo hồng mắt hí',N'H1.jpg',5,N'Trinh 1', 1),
('2',N'Gối ôm đàn gà (3 con)',N'H6.jpg',5,N'Trinh 1', 1),
('3',N'Mèo ngoan',N'H10.jpg',5,N'Trinh 1', 1)
go

insert into Favorite values
('khang','video1','1/1/2022'),
('user2','video2','2/1/2022'),
('user3','video3','3/1/2022'),
('user4','video4','4/1/2022'),
('user5','video5','5/1/2022')
go

insert into Share values
('khang','video1','video1@fpt.edu.vn','6/1/2022'),
('user2','video2','video2@fpt.edu.vn','7/1/2022'),
('user3','video3','video3@fpt.edu.vn','8/1/2022'),
('user4','video4','video4@fpt.edu.vn','9/1/2022'),
('user5','video5','video5@fpt.edu.vn','10/1/2022')
go

select * from Users 
select * from Video 
select * from Favorite 
select * from Share
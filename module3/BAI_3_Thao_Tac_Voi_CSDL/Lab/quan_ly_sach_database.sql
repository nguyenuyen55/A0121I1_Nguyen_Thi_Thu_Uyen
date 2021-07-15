create database Quan_ly_sach;
create table Loai_sach (
ma_loai char(20) primary key,
ten_loai varchar(100));
create table sach(
ma_sach char(30) primary key,
ten_sach varchar(100) ,
nha_san_xuat varchar(100),
tac_gia varchar(100),
nam_sx date ,
so_lan_sx int,
gia int, 
anh varchar(100),
ma_loai char(20),
foreign key  (ma_loai) references Loai_sach(ma_loai)
);
create table Sinh_vien(
ma_sinh_vien char(10) primary key,
ten_sinh_vien varchar(150),
 ngay_sinh date,
 dia_chi varchar(200),
 email varchar(250),
 sdt char(11),
 anh varchar(50));
/*
insert dư lieu vo mỗi bảng 5 dòng
*/
#bang sach
insert into loai_sach(ma_loai,ten_loai)
values("TH",'Tin Học'),
('HH','Hoá học'),
('VH',"Văn Học"),
('GDCD','Giáo dục công nhân'),
('TA',"Tiếng anh");
#luu y fomat date ở đay là yyyy-mm-dd
insert into sach(ma_sach,ten_sach,nha_san_xuat,tac_gia,nam_sx,so_lan_sx,gia,ma_loai)
values('sach01','little stories','kim đồng','stacey riches','1998/05/08',2,456,'TH'),
('sach02','Tiếng anh 11','kim đồng','giáo sư vn','1998/05/08',4,896,'TA'),
('sach03','giáo dục công nhân 12','kim đồng','nguyen van an','1998/05/08',7,456,'GDCD'),
('sach04','Hoá học 11','kim đồng','stacey riches','1998/05/08',8,745,'HH'),
('sach05','Văn Học 10','kim đồng','staces','1998/05/08',2,456,'VH');

insert into sinh_vien(ma_sinh_vien,ten_sinh_vien,ngay_sinh,dia_chi,email,sdt)
values('110','uyen','2000-05-05','02 thanh sơn','uyen@gmail.com','0332001769'),
('111','nga','2000-12-06','ktx phia tay','nga@gmail.com','0337891769'),
('112','tram','2000-11-30','cẩm lệ','tram@gmail.com','0367894769'),
('113','nhi','2000-06-05','gia lai','nhi@gmail.com','0332007896'),
('114','loan','2000-10-07','02 thanh sơn','loan@gmail.com','033568649');
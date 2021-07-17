SELECT * FROM bai2.employees;
create table fake_app(
id int primary key,
name varchar(200),
category varchar(100),
dowloads int ,
price double);

-- them du lieu vao bang fake_app
insert into fake_app
values(3,'silliconphase','Productivity',17913,0),
(6,	'Donzolab',	'Education',	4259,	0.99),
(10,	'Ittechi',	'Reference'	,3874,	0.0),
(13,	'Subdrill',	'Education'	,7132,	1.99);

-- cau lenh ham thong dung
-- cau 1
SELECT *
FROM fake_app;
-- cau 2
 -- dung lenh count : dem co bao nhieu record trong mot bang
 SELECT COUNT(*)
FROM table_name;
-- dem xem co bao nhieu app free
SELECT COUNT(*) 
FROM fake_app
where price =0.0;
-- cau 3
-- tinh tong luot tai xuong trong mot bang
SELECT SUM(dowloads)
FROM fake_app;
-- cau 4 :tim luot tai it nhat trong bang
SELECT MIN(dowloads)
FROM fake_app;
-- tim app cos phi cao nhat
SELECT MIN(dowloads)
FROM fake_app;
-- cau 5: tinh trung binh cua luot tai xuong
SELECT AVG(dowloads)
FROM fake_app;
-- tinh trung binh cua gia trong bang
SELECT AVG(price)
FROM fake_app;
-- cau 6 : hien thi name va gia lam tron len mot so
SELECT name, ROUND(price, 0)
FROM fake_app;
-- lam tron gia tien trung binh len 2 thap phan
SELECT round( AVG(price),2)
FROM fake_app;
-- cau 7: nhom cai gia tien lai
SELECT price, COUNT(*) 
FROM fake_app
GROUP BY price;
-- nhom gia va tong luot tai caur gai do phai lon hon 20000
SELECT price, COUNT(*) 
FROM fake_app
where dowloads>20000 
GROUP BY price;
-- tinh tong luot tai cua tung loai san pham
SELECT category ,SUM(dowloads)
FROM fake_app
GROUP BY category ;
-- cau 8: hien thi loai app , gia va tong luong tai cua loai do
SELECT category, 
   price,
   AVG(dowloads)
FROM fake_app
GROUP BY category, price;
-- cau 9: hien thi ra tien
SELECT price, 
   ROUND(AVG(dowloads)),
   COUNT(*)
FROM fake_app
GROUP BY price
having count(*)>10;



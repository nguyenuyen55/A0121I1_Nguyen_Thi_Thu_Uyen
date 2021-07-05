use classicmodels;

#tìm tên khách hàng băng lệnh where
select *
from customers
where customerName="Atelier graphique"
limit 0,30;
#lấy danh sách nhưng khác hàng có tên có chữ cái A 
select * 
from customers
where customerName like "%A%";
#lấy danh sách khách hàng thuộc các thành phố "Nantes","Las Vegas","Warszawa","NYC"
select *
from customers
where city in ("Nantes","Las Vegas","Warszawa","NYC")
limit 0,30;

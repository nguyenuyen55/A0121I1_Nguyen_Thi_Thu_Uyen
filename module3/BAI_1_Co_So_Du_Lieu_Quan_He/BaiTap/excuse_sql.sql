use classicmodels;
select * from customers;
select customerNumber,customerName,city  
from customers
limit 0,30;
select *
from customers
where city like "%Y%"


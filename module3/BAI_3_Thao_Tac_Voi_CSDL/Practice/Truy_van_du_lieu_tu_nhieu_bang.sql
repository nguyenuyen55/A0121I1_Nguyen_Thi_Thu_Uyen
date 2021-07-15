use classicmodels;
/*
lay customers và payments với điều kiện là các khách hàng sống ở thành 
las vegas
*/
#su dung inner join
select *
from customers
inner join payments
on customers.customerNumber=payments.customerNumber
where city='Las Vegas';
#su dung left join (lay thuoc tính bên bảng bên trái ko trùng cũng lấy hết luôn

/*
tim tat ca các đơn hàng thuộc từng khách hàng 
*/
select *
from customers
left join orders
on customers.customerNumber=orders.customerNumber;
select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers LEFT JOIN orders
on customers.customerNumber = orders.customerNumber
where orderNumber is null
#right tương tự trái nhưng lấy bên phải thôi




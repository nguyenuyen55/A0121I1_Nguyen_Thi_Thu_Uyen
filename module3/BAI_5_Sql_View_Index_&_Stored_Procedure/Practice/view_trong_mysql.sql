-- Tạo View có tên customer_views truy vấn dữ liệu từ bảng customers để 
-- lấy các dữ liệu: customerNumber, customerName, phone
CREATE VIEW customer_views AS

select customerNumber,customerName,phone
from customers;
select * from customer_views;

CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

DROP VIEW customer_views;
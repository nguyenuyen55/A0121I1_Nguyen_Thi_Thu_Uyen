create database demo;
use demo;
create table Products(
 id int primary key,
productCode varchar(45),
productName varchar(50),
productPrice int,
productAmount int,
productDescription varchar(100),
productStatus varchar(45));

-- insert into data
insert into products
values(1,'sp01','keo mut',1000,200,'keo deo rat ngon','con hang'),
(2,'sp07','xe o to',45000,25,' rat ngon','con hang'),
(3,'sp018','banh mi',21000,206990,'keo deo rat ngon','het hang'),
(4,'sp41','banh trang',81000,23,'keo deo rat ngon','con hang'),
(5,'sp010','chan ga',1007,69,'keo deo rat ngon','het hang'),
(65,'sp04','nuoc ngot',5000,100,'keo deo rat ngon','het hang'),
(77,'sp21','Sting',3600,654,'keo deo rat ngon','con hang'),
(8,'sp08','Tra sua',7800,789,'keo deo rat ngon','con hang'),
(9,'sp015','coffee',459,369,'keo deo rat ngon','con hang'),
(51,'sp011','sandwiches',256,66,'keo deo rat ngon','con hang'),
(17,'sp022','book',1000,9334,'keo deo rat ngon','con hang');
delete from products;

select * from products
where productCode='sp015';


select * from products
where productName='keo mut' or productPrice=1000;

-- chi muc unique
CREATE UNIQUE INDEX  idx_productCode
ON products (productCode);

EXPLAIN select * from products
where productCode='sp015';
-- chi muc composite
create index idx_productNameVaproductPrice
on products (productName,productPrice);

explain select * from products
where productName='keo mut' or productPrice=1000;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus 
-- từ bảng products.
	create view view_products
    as select productCode,productName,productPrice,productStatus
    from products;
    
    select * from view_products;
    
    -- sua view
    create or replace view view_products
    as select productCode,productName,productPrice,productStatus
    from products
    where productStatus='con hang';
    
  select * from view_products;
  -- xoa view 
  drop view view_products;
  
  -- Store Procedure
  -- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
  
delimiter $$
create procedure proc_all_products()
begin 
select * from products ;
end; $$
delimiter ; 
call proc_all_products;
 
 -- Tạo store procedure thêm một sản phẩm mới
 
delimiter $$
create procedure proc_insert_products()
begin 
insert into products 
values(19,'sp032','book anime',1000,9334,'rat hay','con hang');
end; $$
delimiter ; 
call proc_insert_products;


-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter $$
create procedure proc_update_Status_products(in idd int(11))
begin 
update products
set productStatus ='het hang'
where id =idd;
end; $$
delimiter ; 
call proc_update_Status_products(4);

-- Tạo store procedure xoá sản phẩm theo id
delimiter $$
create procedure proc_delete_products(in idd int(11))
begin 
delete from products where id =idd;
end; $$
delimiter ; 
call proc_delete_products(1);



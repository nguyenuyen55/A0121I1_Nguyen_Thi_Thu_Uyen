use classicmodels;
/*
su dung and
*/
select productCode,productName,buyPrice,quantityInStock
from products
where buyPrice > 56.76 and quantityInStock>10;
#lay productcode, productname va buyprice tu bang product
#texdescription tu bang productlines voi dieu kien tu 56.76 den 95.59
select products.productCode,products.productName,products.buyPrice,productlines.textDescription
from products
inner join productlines
on products.productLine = productlines.productLine
where buyPrice > 56.76 and buyPrice < 95.59;
/* 
su dung or
*/
select *
from products
where productLine='Classic Cars' or productVendor='Min Lin Diecast'

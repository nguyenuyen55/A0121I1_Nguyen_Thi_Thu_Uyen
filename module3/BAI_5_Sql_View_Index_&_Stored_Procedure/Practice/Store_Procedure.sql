use classicmodels;
DELIMITER $$
create procedure sumNumber(in a int, in b int, out sum int )
begin 
		set sum=a+b;
end; $$
DELIMITER ;
call sumNumber(1,9,@sum);
 select @sum;
 DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

   SELECT *  FROM customers where customerNumber = 175;

END; //

DELIMITER ;

call findAllCustomers();
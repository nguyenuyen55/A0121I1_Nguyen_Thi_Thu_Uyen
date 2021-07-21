-- tham so loai 'in' 
DELIMITER //
CREATE procedure getCusById(in cusNum int(11))
begin 
 select * from customers where customerNumber = cusNum;
 end; //
 delimiter ;
 call getCusById(175);
 
 -- tham so loai out
 delimiter //
 create procedure getCustomerCountByCity(in in_city varchar(50),out total int)
 begin 
 select count(customerNumber)
 into total
 from customers
 where city =in_city;
 end//
 delimiter ;
 CALL getCustomerCountByCity('Lyon',@total);

SELECT @total;

-- tham so loai inout
delimiter //
create procedure SetCounter(inout counter int, in inc int)
begin set counter =counter + inc;
end//
delimiter ;
set @count=1;
call SetCounter(@count,1);
call SetCounter(@count,1);
call SetCounter(@count,1);
call SetCounter(@count,5);
 select @count;
use bai1;

create table constacts
(contact_id int(11) not null auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint constacts_pk primary key (contact_id));

select * from constacts;
create table suppliers
(supplier_id int(11) not null auto_increment,
supperlier_name varchar(50) not null,
account_rep varchar(30) not null default "TBD",
primary key(supplier_id));

#chinh sua bang
ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id;
    ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id,
  ADD first_name varchar(35) NULL
    AFTER last_name;
    ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL;
    ALTER TABLE contacts
  RENAME TO people;
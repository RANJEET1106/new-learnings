create table employees3(id int,name text,age int,salary int);
-- text have unlimted characters
insert into employees3 values(1,'shiva',23,20000);
select * from employees3;

Create table usersnew(
id serial primary key, -- Serial is used as auto increment it starts from 1
username text,
usercity text
);
insert into usersnew(username,usercity) values('shyam','pune');
select * from usersnew;
insert into usersnew(username,usercity) values('Ram','pune');

create table productnew (id int,name text,price double precision,discount float,amount numeric(10,2));
-- double precision have percision of 15 decimals
-- numeric(a,b) have a digits to the left and b digits to the right of decimal point
insert into productnew values(1,'tv',12.3333335,0.30,2344.24);
insert into productnew values(2,'mixer',52.23,0.45,5699.46549);
select * from productnew;

create table ordersnew (order_id serial,order_date date,quantity int,total decimal(8,2));
-- total decimal is treated exactly same as numeric
-- date formate (YYYY-MM-DD)
-- expects input in form of 
	-- 1. YYYY-MM-DD
	-- 2. DD-MM-YYYY
	-- 3. DD-MM-YY
insert into ordersnew(order_date,quantity,total)values('2025-07-04',100,34.3454);
insert into ordersnew(order_date,quantity,total)values('04-07-2025',100,34.3454);
insert into ordersnew(order_date,quantity,total)values('25-07-04',100,34.3454);
insert into ordersnew(order_date,quantity,total)values('25-07-90',100,34.3454);
select * from ordersnew;


create table events1 (event_name varchar(50),event_start timestamp);
insert into events1 values('conference','2024-12-01 09:00:00');
select * from events1;

CREATE Table candidatesdetails(id int PRIMARY KEY,f_name TEXT,l_name TEXT,job_title TEXT,exeriance interval);
insert into candidatesdetails VALUES(1,'arun','pai','manager',interval '10-2' year to month);
-- interval is used for splitting units like 10 years and 2 months
SELECT * FROM candidatesdetails;

CREATE Table students(id int,age int, admitted BOOLEAN);
-- boolean is basically true and false
insert into students VALUES(1,28,'true');
select * FROM students;


CREATE table user6(u_id SERIAL, name VARCHAR(50) NOT NULL,email TEXT[] not null);
-- array data types stores multiple number of items with same data types
INSERT INTO user6(name,email) VALUES('ram','{"ram123@gmail.com","ram222@gmail.com"}');
SELECT * FROM user6;








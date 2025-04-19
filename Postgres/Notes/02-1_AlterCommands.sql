create table students1(
roll_no int primary key,
 f_name varchar(20),
 l_name varchar(20),
 city varchar(20),
 state varchar(20)
);

INSERT INTO students1 (roll_no, f_name, l_name, city, state) VALUES
(1, 'Akalank', 'Jawale', 'Parbhani', 'Maharashtra'),
(2, 'Yash', 'Dutonde', 'Hadapsar', 'Maharashtra'),
(3, 'Ranjeet', 'Deshmukh', 'Karad', 'Maharashtra'),
(4, 'Anish', 'Bhujbal', 'Bhosari', 'Maharashtra'),
(5, 'Atharva', 'Dhemare', 'Chinchwad', 'Maharashtra');

select * from students1;

--explain
explain select * from students1;

-- alter
-- used to hange structure,name,column name of table

-- alter add
alter table students1 add column grade varchar(20);
-- alter drop
alter table students1 drop column grade;
-- alter rename
alter table students1 rename column roll_no to id;
alter table students1 alter column id type numeric(5,2);

create table animal(
id int primary key,
name varchar(20)
);
INSERT INTO animal (id, name) VALUES
(1, 'Lion'),
(2, 'Elephant'),
(3, 'Tiger'),
(4, 'Zebra'),
(5, 'Giraffe');

-- truncate remopves records not table structure
-- drop removes the table structure and its content ,space allocated for table from memory

select * from animal;
truncate table animal;
drop table animal;
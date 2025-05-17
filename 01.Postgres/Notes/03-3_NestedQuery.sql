select * from employee2;

select max(salary) from employee2;

-- number of employees having highest salary
select count(id) 
from employee2 
where salary=(
select max (salary) 
from employee2
);


-- number of emloyees with salary less than average salary
select count(id)
from employee2
where salary<(
select avg(salary)
from employee2
);

-- string functions
select upper('postgresql'); --covert string to upper case
select lower('GOOD MORNING'); --convert into lower case
select char_length('finacle'); --gives length of string 
select initcap('hello word good morning'); -- make first letter of each word capital
select right('infosys',3); -- gives 3 letters from right
select left('bangalore',5); -- gives 5 letters from left of the string

select name from employee2 where right(name,2)='on';

--split_part() function
select * from ordersnew;

--spit(string,separator,limit,position)
select order_date,
split_part(order_date::text,'-',2) as m,
split_part(order_date::text,'-',3) as d
from ordersnew;


-- replace function
update employee2
set dept=replace(dept,'Accounting','account');









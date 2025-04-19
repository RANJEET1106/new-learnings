-- DQL
select * from employees3;

--where statement
select * from studentinfo;
select roll_no ,name,address,age
from studentinfo
where age=18;

-- order by
select roll_no ,name,address,age
from studentinfo
order by age desc;

select roll_no ,name,address,age
from studentinfo
order by age desc nulls first;
select roll_no ,name,address,age
from studentinfo
order by age desc nulls last;


-- aggregate function such as count sum avg min max
select count(*) as TotalStudents from studentinfo;
select sum(age) as TotalAge from studentinfo;
select avg(age) as AverageAge from studentinfo;
select min(age) as LowestAge from studentinfo;
select max(age) as HighestAge from studentinfo;

-- group by
select name,sum(age) as TotalAge
from studentinfo
-- for each group by category we can use aggregate functions
group by name;

select age ,count(roll_no) as number
from studentinfo
group by age
order by age desc nulls last;

select name,age as details
from studentinfo group by age,name;

select salary,count(*) as SALARY_DETAILS from employee
where salary>5000 group by salary

-- Having 
-- having is similar to where but apply on group by clause
select name,sum(salary) as salary_details
from employee
group by name
having sum(salary)>5000

select age ,count(roll_no) as number
from studentinfo
group by age
having count(roll_no)>40
order by number asc
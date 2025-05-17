select * from employee2;

-- distinct
select dept from employee2 order by dept;
select distinct dept from employee2 order by dept;

-- limit
select name ,id from employee2 order by employee2 limit 3;
select name ,id from employee2 order by employee2 limit 3 offset 2;
-- offset ignores the first n rows
-- limit selects first n numbers from the offset

-- fetch
select name,id from employee2 order by id fetch first 4 rows only;

-- AND Operator
select name,dept,salary from employee2 where dept='Engineering' and salary=25000;

-- OR Operator
select name,dept,salary from employee2 where dept='Engineering' or salary=25000;

-- Between
select id,name from employee2 where id between 30 and 40;
select id,name from employee2 where id not between 5 and 997;

-- Like operator matches the pattern
-- % matches for 0 or more characters
-- _ matches for a single character

select id,name from employee2 where name like '%ea';
-- matches the string ending with ea

select id,name from employee2 where name like 'La%';
-- like '%ch%' match the string containing ch
-- like '%are_' match the string containing are followed by a single char




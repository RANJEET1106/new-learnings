create table zoo1(id int ,animal varchar(20));
insert into zoo1 values (1,'LION'),(2,'TIGER'),(3,'WOLF'),(4,'FOX');


create table zoo2(id int ,animal varchar(20));
insert into zoo2 values (1,'TIGER'),(2,'LION'),(3,'RHINO'),(4,'PANTHER');


-- inner join
select zoo1.id as id_a,
zoo1.animal animal_a,
zoo2.id id_b,
zoo2.animal animal_b
from zoo1
inner join zoo2 on zoo1.animal=zoo2.animal;

-- left join
select zoo1.id,zoo1.animal,zoo2.id,zoo2.animal
from zoo1
left join zoo2 on zoo1.animal=zoo2.animal;

-- right join
select zoo1.id,zoo1.animal,zoo2.id,zoo2.animal
from zoo1
right join zoo2 on zoo1.animal=zoo2.animal;

-- full join
select zoo1.id,zoo1.animal,zoo2.id,zoo2.animal
from zoo1
full join zoo2 on zoo1.animal=zoo2.animal;

-- cross join
select zoo1.id,zoo1.animal,zoo2.id,zoo2.animal
from zoo1
cross join zoo2 ;

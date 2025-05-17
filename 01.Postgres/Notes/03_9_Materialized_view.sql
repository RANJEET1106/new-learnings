-- database northwind2

select * from prod_view2;

create or replace view v_pro1 as
select * from products
where product_name='Chai'
with check option;
-- check option is basically checks the where condition
-- data gets inserted only when the where clause satisfies
-- i.e. i can insert the values with product_name='Chai' but not other


select * from v_pro1;

insert into v_pro1
(product_id,product_name,discontinued)
values(999,'Chai',0);

select * from products;

insert into v_pro1
(product_id,product_name,discontinued)
values(996,'Biscuits',0);

-- materialized view
create table random_tab2(id int,val decimal);
insert into random_tab2 select 1,random() 
from generate_series(1,10000000);
insert into random_tab2 select 2,random() 
from generate_series(1,10000000);

select * from random_tab2;

select id,avg(val),count(*)
from random_tab2
group by id;

create materialized view my_random_tab2
as
select id,avg(val),count(*)
from random_tab2
group by id;

select * from my_random_tab2;

delete from random_tab2 where id=1;

refresh materialized view my_random_tab2;

drop materialized view my_random_tab2;
drop table random_tab2;

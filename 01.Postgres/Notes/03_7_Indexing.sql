-- northwind2 database

select * from customers;
select * from customers where contact_title='Owner';

explain analyze select * from customers where contact_title='Owner';

create index indexdemo on customers(contact_title);
explain analyze select * from customers where contact_title='Owner';


select * from orders;
explain analyse select order_id,ship_country
from orders
where ship_country='France';

create index ship_idx1 on orders(ship_country);

explain analyse select order_id,ship_country
from orders
where ship_country='France';

-- 
explain analyse select order_id,ship_via
from orders
where ship_via=3;

create index sindex on orders(ship_via);

explain analyse select order_id,ship_via
from orders
where ship_via=3;








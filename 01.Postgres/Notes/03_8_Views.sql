-- northwind2 database

select * from products;

create or replace view prod_view2 as
select * from products where supplier_id=3;

select * from prod_view2;
update prod_view2 set unit_price=100 where product_id=6;

select * from products;

create or replace view orderviewdemo as
select customers.customer_id, customers.contact_name,orders.order_id
from orders,customers
where orders.customer_id=customers.customer_id;

select * from orderviewdemo;

insert into prod_view2
(product_id,product_name,unit_price,discontinued)
values (200,'dryfruits',250,1);

select * from prod_view2;
select * from products;






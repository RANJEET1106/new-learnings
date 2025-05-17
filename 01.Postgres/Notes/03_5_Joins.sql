-- northwind2 database

-- left join

select company_name,order_id
from customers
left join orders on customers.customer_id=orders.customer_id;

select * from customers;
select * from orders;


select company_name,order_id
from customers
left join orders on customers.customer_id=orders.customer_id
where order_id is null;

-- right join

select company_name,order_id
from customers
right join orders on customers.customer_id=orders.customer_id;

select company_name,order_id
from customers
right join orders on customers.customer_id=orders.customer_id
where order_id is null;

-- full join

select company_name,order_id
from customers
full join orders on customers.customer_id=orders.customer_id;

select product_name,category_name
from categories
full join products on
products.category_id=categories.category_id;


-- self join 

-- find customers who are in same city and order by city
select a.company_name as customername1,b.company_name as customername2,a.city
from customers a,customers b
where a.customer_id>b.customer_id
and a.city=b.city
order by city;

-- find the suppliers from same country and orderr by country
 select a.company_name as suppliername1,b.company_name as suppliername2,a.country
 from suppliers a,suppliers b
 where a.supplier_id>b.supplier_id
 and a.country=b.country
 order by a.country;

-- cross join
create table department(dept_id int,dept_name text);
insert into department 
values
(1,'HR'),
(2,'IT'),
(3,'SALES'),
(4,'FINANCE');

SELECT e.employee_id,e.first_name,e.last_name,
d.dept_id,d.dept_name
from employees e cross join department d
order by e.employee_id;


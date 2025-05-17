create table users(
user_id int primary key,
name varchar(100) not null,
email varchar(100) unique not null,
phone varchar(15) unique not null,
location varchar(100)
);

create table restaurants(
restaurant_id int primary key,
name varchar(100) not null,
location varchar(100),
cuisine varchar(50),
rating decimal(2,1) check (rating>=0 and rating<=5)
);

create table menu(
menu_id int primary key,
restaurant_id int,
item_name varchar(100) not null,
price decimal(10,2) not null check (price>=0),
is_available boolean default true,
foreign key (restaurant_id) references restaurants(restaurant_id)
);

create table orders(
order_id serial primary key,
user_id int,
restaurant_id int,
order_date date not null,
status varchar(50),
foreign key (user_id) references users(user_id),
foreign key (restaurant_id) references restaurants(restaurant_id)
);

create table order_items(
order_item_id serial primary key,
order_id int,
menu_id int,
quantity int not null check (quantity>0),
foreign key (order_id) references orders(order_id),
foreign key (menu_id) references menu(menu_id)
);

create table reviews(
review_id int primary key,
user_id int,
restaurant_id int,
rating decimal(2,1) not null check (rating>=0 and rating<=5),
review_text text,
review_date date not null,
foreign key (user_id) references users(user_id),
foreign key (restaurant_id) references restaurants(restaurant_id)
);

drop table order_items cascade;

insert into users(user_id, name, email, phone, location) values
(1, 'akalank jawale', 'akalankjawale@gmail.com', '9513653999', 'parbhani'),
(2, 'yash dutonde', 'yashdutonde@gmail.com', '9913847339', 'hadapsar'),
(3, 'ranjeet deshmukh', 'ranjeetdeshmukh@gmail.com', '9551585301', 'karad'),
(4, 'sushant zambare', 'sushantzambare@gmail.com', '9143469773', 'jalgaon'),
(5, 'mayank agrawal', 'mayankagrawal@gmail.com', '9378009742', 'dhule'),
(6, 'vedant patil', 'vedantpatil@gmail.com', '9648977048', 'sambhajinagar');

insert into restaurants (restaurant_id, name, location, cuisine, rating) values
(1, 'Panjabi Tadaka', 'Satara', 'North Indian', 4.9),
(2, 'Aai’s Kitchen', 'Kolhapur', 'Maharashtrian', 4.0),
(3, 'Mohit Dosa', 'Nagpur', 'South Indian', 3.5),
(4, 'Shiv Vadapav', 'Nanded', 'Fast Food', 2.5),
(5, 'Pizza Palace', 'Chinchwad', 'Italian', 4.8);

truncate table restaurants cascade;

insert into menu(menu_id, restaurant_id, item_name, price, is_available) values
(1, 1, 'Veg Thali', 115.00, true),
(2, 2, 'Chole Bhature', 40.00, false),
(3, 3, 'Dosa', 40.00, true),
(4, 4, 'Vada Pav', 15.00, false),
(5, 5, 'Margherita Pizza', 250.00, true),
(6, 5, 'Veg Pizza', 220.00, true);



insert into orders(order_id, user_id, restaurant_id, order_date, status) values
(1, 1, 1, '2025-05-13', 'delivered'),
(2, 2, 2, '2025-05-13', 'delivered'),
(3, 2, 3, '2025-05-13', 'delivered'),
(4, 4, 3, '2025-05-13', 'delivered');


insert into order_items(order_item_id, order_id, menu_id, quantity) values
(1, 1, 1, 2),  
(2, 2, 2, 1), 
(3, 2, 3, 3),  
(4, 3, 3, 2);  


insert into reviews(review_id, user_id, restaurant_id, rating, review_text, review_date) values
(1, 1, 1, 4, 'Good', '2025-05-10'),
(2, 2, 2, 3, 'Okay', '2025-05-11'),
(3, 2, 3, 1, 'Bad', '2025-05-12'),
(4, 4, 3, 1, 'Do not buy', '2025-05-12');


-- Q2. List all restaurants along with their location and cuisine. 
select name, location, cuisine from restaurants;

-- Q3. List all menu items with their prices and availability for the restaurant named "Pizza Palace".
select item_name, price, is_available
from menu
join restaurants on menu.restaurant_id = restaurants.restaurant_id
where restaurants.name = 'Pizza Palace';

-- Q4. Display the total number of users in each location.
select location, count(*) as count
from users
group by location;


-- Q5. List all orders with user name, restaurant name, and number of items in the order.
select u.name as user_name, r.name as restaurant_name, sum(oi.quantity) as number_of_items
from orders o
join users u on o.user_id = u.user_id
join restaurants r on o.restaurant_id = r.restaurant_id
join order_items oi on o.order_id = oi.order_id
group by o.order_id, u.name, r.name;

-- Q6. Find the average rating of each restaurant and list them in descending order.
select r.name as restaurant_name, avg(rv.rating) as average_rating
from reviews rv
join restaurants r on rv.restaurant_id = r.restaurant_id
group by r.name
order by average_rating desc;

-- Q7. Find the users who have never placed an order.

select u.name
from users u
left join orders o on u.user_id = o.user_id
where o.order_id is null;

-- Q8. Update all menu items by increasing their price by 10% where the current price is below 200.

update menu
set price = price * 1.10
where price < 200;

select menu_id as ID, price as Price from menu;

-- Q9. Find all restaurants that serve more menu items than the average number of items across all restaurants.

select r.name, count(m.menu_id) as item_count
from restaurants r
join menu m on r.restaurant_id = m.restaurant_id
group by r.restaurant_id, r.name
having count(m.menu_id) > (
    select avg(item_count)
    from (
        select count(*) as item_count
        from menu
        group by restaurant_id
    ) as counts
);

-- Q10. Get the top 3 most ordered items across all restaurants.

select m.item_name, sum(oi.quantity) as total_ordered
from order_items oi
join menu m on oi.menu_id = m.menu_id
group by m.item_name
order by total_ordered desc
limit 3;

-- Q11. Create function get_total_order_amount(p_order_id int)
create or replace function get_total_order_amount(p_order_id int)
returns numeric
language plpgsql
as $$
declare
    total numeric := 0;
begin
    select sum(m.price * oi.quantity)
    into total
    from order_items oi
    join menu m on oi.menu_id = m.menu_id
    where oi.order_id = p_order_id;

    return total;
end;
$$;

select get_total_order_amount(1);
select get_total_order_amount(2);
select get_total_order_amount(3);
select get_total_order_amount(4);


-- Q12. Stored procedure place_order to insert into orders and order_items.

create or replace procedure place_order(
    p_user_id int,
    p_restaurant_id int,
    p_item_ids int[],
    p_quantities int[]
)
language plpgsql
as $$
declare
    v_order_id int;
    i int;
begin
    insert into orders(user_id, restaurant_id, order_date, status)
    values (p_user_id, p_restaurant_id, current_date, 'placed')
    returning order_id into v_order_id;

    for i in array_lower(p_item_ids, 1)..array_upper(p_item_ids, 1) loop
        insert into order_items(order_id, menu_id, quantity)
        values (v_order_id, p_item_ids[i], p_quantities[i]);
    end loop;
end;
$$;



call place_order(1,2,array[3, 4],array[2, 1]);
select * from orders ;

select * from order_items;



-- Q13. Trigger to update restaurant's average rating after a new review is inserted.

create or replace function update_avg_rating()
returns trigger
language plpgsql
as $$
begin
    update restaurants
    set rating = (
        select avg(rating)
        from reviews
        where restaurant_id = new.restaurant_id
    )
    where restaurant_id = new.restaurant_id;
    return new;
end;
$$;

create trigger trg_update_avg_rating
after insert on reviews
for each row
execute function update_avg_rating();

select * from restaurants where restaurant_id=1;

insert into reviews (review_id, user_id, restaurant_id, rating, review_text, review_date)
values (6, 1, 1, 5.0, 'Excellent food and service!', current_date);
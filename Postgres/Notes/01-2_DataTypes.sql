--UUID -UNIVERSALLY UNIQUE IDENTIFIERS 128 BIT VALUE
-- globle uniquness across all the system
-- globally accepted

create extension "uuid-ossp";
create table contactdetails(
contact_id uuid default public.uuid_generate_v1(),
-- uuid_generate_v1() uses version1 which uses mac address and timestamp to generate uuid
-- similarly we can use v2,v3,v4
	f_name varchar,
	l_name varchar,
	phone varchar,
	primary key (contact_id)
);

insert into contactdetails(f_name,l_name,phone) values
('raju','kumar','9999999999'),
('nikhil','sharma','8888888888'),
('anushka','dutonde','7777777777');

select * from contactdetails;


-- JSON datatype
-- in json datatype we don't need to define any schema structure

create table ordernew1(
id serial primary key,
info json not null
);

insert into ordernew1(info) 
values('{"customer":"radha","items":{"products":"cofee","qty":6}}');
select * from ordernew1;

create table studentdemo(
s_id serial primary key,
info json not null
);
insert into studentdemo(info) values
('{"name":"disha","sem":3}'),
('{"name":"yash","sem":2}'),
('{"name":"akalank","sem":4}'),
('{"name":"RANJEET","sem":4}');
select * from studentdemo;


-- XML datatype
create table personnew3(
id serial primary key,
info xml);

INSERT INTO personnew3(info) 
VALUES 
(
    XMLPARSE(DOCUMENT '<?xml version="1.0" encoding="UTF-8"?>
        <personnew3>
            <name>Yash</name>
            <age>25</age>
            <city>Hadapsar</city>
        </personnew3>')
),
(
    XMLPARSE(DOCUMENT '<?xml version="1.0" encoding="UTF-8"?>
        <personnew3>
            <name>Akalank</name>
            <age>30</age>
            <city>Parbhani</city>
        </personnew3>')
),
(
    XMLPARSE(DOCUMENT '<?xml version="1.0" encoding="UTF-8"?>
        <personnew3>
            <name>Ranjeet</name>
            <age>28</age>
            <city>Karad</city>
        </personnew3>')
);

select xpath('/personnew3/name/text()',info) as name from personnew3;
select xpath('/personnew3/age/text()',info) as age from personnew3;
select xpath('/personnew3/city/text()',info) as city from personnew3;
-- parsing from int to text is not available in xml
-- all data should be stored as text

SELECT
    xpath('/personnew3/name/text()', info) AS name,
    xpath('/personnew3/age/text()', info) AS age,
    xpath('/personnew3/city/text()', info) AS city
FROM personnew3;


-- hstore
-- everything is stored in form of string
-- No nested key values pair

-- create extension hstore;
create extension "hstore";
create table country1(
id serial primary key,
attr hstore
);
insert into country1(attr) values
('"karnataka"=>"banglore"'),
('"maharashtra"=>"bombay"'),
('"tamilnadu"=>"chennai"');

select * from country1;
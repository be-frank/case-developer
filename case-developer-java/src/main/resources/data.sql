--Use this file to populate the tables in the H2 database, remove create table statement and replace by your own script

insert into deelnemer(id,name,birth_date,email_address,phone_number)
values(1,'Henk de Groot','1970-01-21','gekkehenk@dds.nl','06123456789')
;
insert into deelnemer(id,name,birth_date,email_address,phone_number,service_start_date,service_fulltime_salary,service_parttime_percentage,service_franchise,service_premium_percentage,service_investment_account)
values(2,'Piet Pietsema','1963-07-19','mieters@gmail.com','06123456789','1995-04-01','60000','0.8','15599','0.05','10001')
;
insert into deelnemer(id,name,birth_date,email_address,phone_number,service_start_date,service_fulltime_salary)
values(3,'Andrea de Vries','2001-09-11','blitz@haxx0rworld.com','06123456789','2020-06-01','35000')
;
insert into deelnemer(id,name,birth_date,email_address,phone_number)
values(4,'Jannes van der Wal','1965-06-04','ikbenjannes@ergensin.nl','06123456789')
;
insert into deelnemer(id,name,birth_date,email_address,phone_number)
values(5,'Diederik van Voor-tot Achter','1948-05-10','ikdoenietaanemail@hotmail.com','06123456789')
;
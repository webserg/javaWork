insert into salespeople values (1001,'Peel','London',0.12);
insert into salespeople values (1002,'Serres', 'San Jose', 0.13);
insert into salespeople values (1004,'Motika', 'London', 0.11);
insert into salespeople values (1007,'Rifkin', 'Barcelona', 0.15);
insert into salespeople values (1003,'Axelrod', 'New York', 0.10);


insert into customers(cnum,cname,city,rating,snum) values(2001,'Hoffman','London',100,1001);
insert into customers(cnum,cname,city,rating,snum) values(2002,'Giovanni','Rome', 200, 1003);
insert into customers(cnum,cname,city,rating,snum) values(2003,'Liu San','Jose', 200, 1002);
insert into customers(cnum,cname,city,rating,snum) values(2004,'Grass','Berlin', 300, 1002);
insert into customers(cnum,cname,city,rating,snum) values(2006,'Clemens','London', 100, 1001);
insert into customers(cnum,cname,city,rating,snum) values(2008,'Cisneros','San Jose', 300, 1007);
insert into customers(cnum,cname,city,rating,snum) values(2007,'Pereira','Rome', 100, 1004);

insert into orders(onum,amt,odate,cnum,snum) values(3001,18.69,'10/03/1990',2008,1007);
insert into orders(onum,amt,odate,cnum,snum) values(3003, 767.19, '10/03/1990' ,2001, 1001);
insert into orders(onum,amt,odate,cnum,snum) values(3002, 1900.10, '10/03/1990', 2007, 1004);
insert into orders(onum,amt,odate,cnum,snum) values(3005, 5160.45, '10/03/1990', 2003, 1002);
insert into orders(onum,amt,odate,cnum,snum) values(3006, 1098.16, '10/03/1990', 2008, 1007);
insert into orders(onum,amt,odate,cnum,snum) values(3009, 1713.23, '10/04/1990', 2002, 1003);
insert into orders(onum,amt,odate,cnum,snum) values(3007, 75.75, '10/04/1990' ,2004, 1002);
insert into orders(onum,amt,odate,cnum,snum) values(3008, 4723.00, '10/05/1990', 2006, 1001);
insert into orders(onum,amt,odate,cnum,snum) values(3010, 1309.95, '10/06/1990' ,2004, 1002);
insert into orders(onum,amt,odate,cnum,snum) values(3011, 9891.88, '10/06/1990' ,2006, 1001);
CREATE TABLE salespeople
(
 snum int NOT NULL PRIMARY KEY,
 sname char (10) NOT NULL,
 city char (10) NOT NULL,
 comm float  NOT NULL
);

CREATE TABLE customers
(
 cnum integer NOT NULL PRIMARY KEY,
 cname char (10) NOT NULL,
 city char (10) NOT NULL,
 rating int NOT NULL,
 snum int NOT NULL
);

CREATE TABLE orders
(
  onum int NOT NULL PRIMARY KEY,
  amt float NOT NULL,
  odate date NOT NULL,
  cnum int NOT NULL,
  snum int  NOT NULL
);

ALTER TABLE customers ADD CONSTRAINT snum_fk FOREIGN KEY (snum) REFERENCES salespeople (snum);
ALTER TABLE orders ADD CONSTRAINT cnum_fk FOREIGN KEY (cnum) REFERENCES customers (cnum);
ALTER TABLE orders ADD CONSTRAINT snum_orders_fk FOREIGN KEY (snum) REFERENCES salespeople (snum);

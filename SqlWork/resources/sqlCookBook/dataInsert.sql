CREATE TABLE emp
(
  EMPNO int NOT NULL PRIMARY KEY,
  ENAME varchar(50) NOT NULL,
  JOB varchar(50) NOT NULL,
  MGR int ,
  HIREDATE  date NOT NULL,
  SAL   float NOT NULL
,  COMM  float,
  DEPTNO int NOT NULL
);
CREATE TABLE dept
(
  DEPTNO int NOT NULL PRIMARY KEY,
  DNAME  varchar(50) NOT NULL,
  LOC  varchar(50) NOT NULL
);
CREATE TABLE emp_bonus
(
  EMPNO int NOT NULL PRIMARY KEY,
  RECEIVED  date NOT NULL,
  TYPE  int NOT NULL
);
ALTER TABLE emp ADD CONSTRAINT dept_fk FOREIGN KEY (DEPTNO) REFERENCES dept(DEPTNO);
create index emp_mgr on emp(MGR);
ALTER TABLE emp ADD CONSTRAINT mgr_fk FOREIGN KEY (MGR) REFERENCES emp(EMPNO) on delete cascade;

ALTER TABLE emp ADD email varchar(50);
create index emp_email_idx on emp(email);
ALTER TABLE emp ADD constraint emp_email_ck check ((instr(email,'@') > 0) and (instr(email,'.') > 0));

insert into dept(DEPTNO,DNAME,LOC) values(10,'ACCOUNTING','NEW YORK');
insert into dept(DEPTNO,DNAME,LOC) values(20,'RESEARCH','DALLAS');
insert into dept(DEPTNO,DNAME,LOC) values(30,'SALES','CHICAGO');
insert into dept(DEPTNO,DNAME,LOC) values(40,'OPERATIONS','BOSTON');



insert into emp_bonus(EMPNO,RECEIVED,TYPE) values(7369,'14-MAR-2005',1);
insert into emp_bonus(EMPNO,RECEIVED,TYPE) values(7900,'14-MAR-2005',2);
insert into emp_bonus(EMPNO,RECEIVED,TYPE) values(7788,'14-MAR-2005',3);


insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7369,'SMITH','CLERK',7902,'17-DEC-1980',800,20);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7499,'ALLEN','SALESMAN', 7698, '20-FEB-1981', 1600,  300 , 30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7521,'WARD','SALESMAN', 7698, '22-FEB-1981', 1250,  500,  30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7566,'JONES','MANAGER',7839, '02-APR-1981', 2975,   20);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7654,'MARTIN','SALESMAN',7698,' 28-SEP-1981', 1250, 1400,  30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7698,'BLAKE','MANAGER', 7839,' 01-MAY-1981', 2850,    30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7782,'CLARK','MANAGER', 7839,' 09-JUN-1981', 2450 ,   10);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values ( 7788,'SCOTT','ANALYST', 7566,' 09-DEC-1982', 3000 ,   20);
insert into emp(EMPNO,ENAME,JOB,HIREDATE,SAL,DEPTNO) values ( 7839,'KING','PRESIDENT',  '17-NOV-1981', 5000 ,          10);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7844,'TURNER','SALESMAN',  7698,'08-SEP-1981', 1500 ,   0,   30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values ( 7876,'ADAMS','CLERK',7788,'12-JAN-1983', 1100 , 20);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7900,'JAMES','CLERK', 7698,'03-DEC-1981',  950 , 30);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7902,'FORD','ANALYST',7566,'03-DEC-1981', 3000 , 20);
insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values (7934,'MILLER','CLERK',7782,'23-JAN-1982', 1300 , 10);

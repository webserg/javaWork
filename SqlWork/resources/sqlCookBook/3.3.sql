--You want to find common rows between two tables but there are multiple columns on which you can join. For example, consider the following view V:

	
	create view V
	as
	select ename,job,sal
	  from emp
	 where job = 'CLERK'

	select * from V

--	ENAME       JOB              SAL
	----------  --------- ----------
--	SMITH       CLERK            800
--	ADAMS       CLERK           1100
--	JAMES       CLERK            950
--	MILLER      CLERK           1300



--Only clerks are returned from view V. However, the view does not show all possible EMP columns. You want to return the EMPNO, ENAME, JOB, SAL, and DEPTNO of all employees in EMP that match the rows from view V. You want the --result set to be the following:

/*	   EMPNO  ENAME       JOB             SAL     DEPTNO
	--------  ----------  --------- ---------- ---------
	   7369   SMITH       CLERK           800         20
	   7876   ADAMS       CLERK          1100         20
	   7900   JAMES       CLERK           950         30
	   7934   MILLER      CLERK          1300         10

*/
select empno,ename,job,sal,deptno
	   from emp
	  where (ename,job,sal) in (
	   select ename,job,sal from emp
	  intersect
	   select ename,job,sal from V
	  )



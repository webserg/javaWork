/*
Recipe 3.6. Adding Joins to a Query Without Interfering with Other Joins
Problem
You have a query that returns the results you want. You need additional information, but when trying to get it, you lose data from the original result set. For example, you want to return all employees, the location of the department in which they work, and the date they received a bonus. For this problem, the EMP_BONUS table contains the following data:

	
	select * from emp_bonus

	      EMPNO  RECEIVED          TYPE
	 ----------  ----------- ----------
	       7369  14-MAR-2005          1
	       7900  14-MAR-2005          2
	       7788  14-MAR-2005          3



The query you start with looks like this:

	
	select e.ename, d.loc
	  from emp e, dept d
	 where e.deptno=d.deptno

	  ENAME      LOC
	  ---------- -------------
	  SMITH      DALLAS
	  ALLEN      CHICAGO
	  WARD       CHICAGO
	  JONES      DALLAS
	  MARTIN     CHICAGO
	  BLAKE      CHICAGO
	  CLARK      NEW YORK
	  SCOTT      DALLAS
	  KING       NEW YORK
	  TURNER     CHICAGO
	  ADAMS      DALLAS
	  JAMES      CHICAGO
	  FORD       DALLAS
	  MILLER     NEW YORK



You want to add to these results the date a bonus was given to an employee, but joining to the EMP_BONUS table returns fewer rows than you wish because not every employee has a bonus:

	
	select e.ename, d.loc,eb.received
	  from emp e, dept d, emp_bonus eb
	 where e.deptno=d.deptno
	   and e.empno=eb.empno

	ENAME       LOC           RECEIVED
	----------  ------------- -----------
	SCOTT       DALLAS        14-MAR-2005
	SMITH       DALLAS        14-MAR-2005
	JAMES       CHICAGO       14-MAR-2005



Your desired result set is the following:

	ENAME       LOC            RECEIVED
	----------  -------------  -----------
	ALLEN       CHICAGO
	WARD        CHICAGO
	MARTIN      CHICAGO
	JAMES       CHICAGO        14-MAR-2005
	TURNER      CHICAGO
	BLAKE       CHICAGO
	SMITH       DALLAS         14-MAR-2005
	FORD        DALLAS
	ADAMS       DALLAS
	JONES       DALLAS
	SCOTT       DALLAS         14-MAR-2005
	CLARK       NEW YORK
	KING        NEW YORK
	MILLER      NEW YORK

*/

 select e.ename, d.loc, eb.received
	   from emp e join dept d
	     on (e.deptno=d.deptno)
	   left join emp_bonus eb
	     on (e.empno=eb.empno)
	  order by 1
	  
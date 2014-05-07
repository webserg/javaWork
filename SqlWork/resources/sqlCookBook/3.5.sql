/*
You want to find rows that are in one table that do not have a match in another table, for two tables that have common keys. For example, you want to find which departments have no employees. The result set should be the following:

	      DEPTNO  DNAME           LOC
	  ----------  --------------  -------------
	          40  OPERATIONS      BOSTON



Finding the department each employee works in requires an equi-join on DEPTNO from EMP to DEPT. The DEPTNO column represents the common value between tables. Unfortunately, an equi-join will not show you which department has no employees. That's because by equi-joining EMP and DEPT you are returning all rows that satisfy the join condition. Instead you want only those rows from DEPT that do not satisfy the join condition.

This is a subtly different problem than in the preceding recipe, though at first glance they may seem the same. The difference is that the preceding recipe yields only a list of department numbers not represented in table EMP. Using this recipe, however, you can easily return other columns from the DEPT table; you can return more than just department numbers.

*/
 --select d.* from dept d, emp e where d.deptno = e.deptno (+) and e.deptno is null
select d.* from dept d left outer join emp e on (d.deptno = e.deptno) where e.deptno is null
--You wish to find those values in one table, call it the source table, that do not also exist in some target table. For example, you want to find which --departments (if any) in table DEPT do not exist in table EMP. In the example data, DEPTNO 40 from table DEPT does not exist in table EMP, so the result set --should be the following:
/*
	      DEPTNO
	  ----------
	    40
*/
--solution 
select deptno from dept where deptno not in (select deptno from emp group by deptno);
-- (deptno=10 or deptno=50 or deptno=null) is the same  not in ( 10,50,null )

--  or
select deptno from dept minus select deptno from emp
--  In SQL, "TRUE or NULL" is TRUE, but "FALSE or NULL" is NULL! And once you have a NULL result, you'll continue to have NULL result 
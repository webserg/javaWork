/*

select all workers and their bosses

Query 3 performs a self-join with the JOIN . . . ON clause by aliasing the emp
table as f1 and f2. Oracle treats these as different tables even though they point to the
same physical table
*/
select e1.ename worker,e1.job job_of_worker,e2.ename boss,e2.job job_of_boss from emp e1 join emp e2 on (e1.mgr = e2.empno);
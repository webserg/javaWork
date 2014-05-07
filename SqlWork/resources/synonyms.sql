create view dept_anon_v as
select department_id,department_name,location_id from departments;

create view dep_sum_v as select e.department_id,count(1) staff, sum(e.salary) salaries,
d.department_name from emp_anon_v e join dept_anon_v d
on e.department_id=d.department_id
group by e.department_id,d.department_name;

create synonym emp_s for emp_anon_v;
create synonym dept_s for dept_anon_v;
create synonym dsum_s for dep_sum_v;
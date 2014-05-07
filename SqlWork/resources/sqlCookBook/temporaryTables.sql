select object_type,count(object_type) from all_objects group by object_type order by object_type;
create global temporary table tmp_emp (dept number,salary number);
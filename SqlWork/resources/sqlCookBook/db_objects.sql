select object_type,count(object_type) from dba_objects group by object_type order by object_type;  --for system
select object_type,count(object_type) from user_objects group by object_type order by object_type;
select object_type,count(object_type) from all_objects group by object_type order by object_type;
select column_name,data_type,nullable,data_length,data_precision,data_scale from user_tab_columns where table_name='EMPLOYEES';
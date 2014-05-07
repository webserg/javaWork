--create sequence order_seq start with 10;
--create sequence line_seq start with 10;

insert into orders (order_id,order_date,customer_id)
values (order_seq.nextval,sysdate,'1000');
insert into order_items (order_id,order_item_id,product_id)
values (order_seq.currval,line_seq.nextval,'A111');
insert into order_items (order_id,order_item_id,product_id)
values (order_seq.currval,line_seq.nextval,'B111');
commit;

create sequence seq1 start with 10 nocache maxvalue 15 cycle;
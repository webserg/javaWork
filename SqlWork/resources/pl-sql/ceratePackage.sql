create package numbers as
	function half_of_square(original NUMBER) return number;
	procedure ins_ints(v1 in number);
end numbers;
/
create PACKAGE BODY numbers AS

  FUNCTION half_of_square(original NUMBER)
  RETURN NUMBER IS
  BEGIN
    RETURN (original * original)/2 + (original * 4);
  END half_of_square;
  
  PROCEDURE ins_ints(v1 NUMBER) IS
  BEGIN
   DBMS_OUTPUT.PUT_LINE('number: ' || v1);
  END;

END numbers;
/
-- call function: select numbers.half_of_square(2) n from dual;
-- call procedure: exec numbers.ins_ints(2)
--select * from V$LOCKED_OBJECT; monitoring locks using SYS account
--select * from V$LOCK;
CREATE OR REPLACE FUNCTION next_employee_id
RETURN NUMBER
AS
   v_employee_id     NUMBER;
   v_max_employee_id NUMBER;
BEGIN
   SELECT employee_id
   INTO v_employee_id
   FROM employees
   v_max_employee_id := MAX(v_employee_id) + 1;
   RETURN v_max_employee_id;
END;
/

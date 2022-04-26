CREATE OR REPLACE FUNCTION next_employee_id
RETURN NUMBER
AS
   v_employee_id     employees.employee_id%TYPE;
   v_max_employee_id NUMBER;
BEGIN
   SELECT MAX(employee_id)
   INTO v_employee_id
   FROM employees;
   v_max_employee_id := v_employee_id + 1;
   RETURN v_max_employee_id;
END;
/

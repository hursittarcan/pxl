CREATE OR REPLACE FUNCTION bruto_jaarloon
(p_emp_id   employees.employee_id%TYPE)
RETURN NUMBER
AS
   v_salary          employees.salary%TYPE;
   v_commission_pct  employees.commission_pct%TYPE;
   v_total_salary    NUMBER;
BEGIN
   SELECT salary, NVL(commission_pct, 0)
   INTO v_salary, v_commission_pct
   FROM employees
   WHERE employee_id = p_emp_id;
   v_total_salary := (v_salary + (v_salary * v_commission_pct)) * 12;
   RETURN v_total_salary;
END;
/
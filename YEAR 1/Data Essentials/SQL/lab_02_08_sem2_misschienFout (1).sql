CREATE OR REPLACE FUNCTION manager_meeste_werknemers
RETURN VARCHAR2
AS
      v_voornaam     VARCHAR2(40);
      v_naam         VARCHAR2(40);
      v_depid        NUMBER(3);
      v_countemp     NUMBER(3);
      v_manager_id   NUMBER(3);
BEGIN
      SELECT d.department_id, COUNT(e.employee_id)
      INTO v_depid, v_countemp
      FROM departments d JOIN employees e ON (e.department_id = d.department_id)
      GROUP BY d.department_id
      HAVING COUNT(e.employee_id) = (SELECT MAX(COUNT(department_id)) 
                                     FROM employees
                                     GROUP BY department_id);
      SELECT manager_id
      INTO v_manager_id
      FROM departments
      WHERE department_id = v_depid;

      SELECT first_name, last_name
      INTO v_voornaam, v_naam
      FROM employees 
      WHERE manager_id = v_manager_id;
      RETURN v_voornaam || ' ' || v_naam;
END;
/

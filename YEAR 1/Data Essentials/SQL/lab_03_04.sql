CREATE OR REPLACE PROCEDURE minimumlonen
    (p_landnaam           IN   countries.country_name%TYPE
    ,p_nieuw_minimumloon  IN   employees.salary%TYPE)
AS
BEGIN
    UPDATE employees
    SET salary = p_nieuw_minimumloon
    WHERE department_id IN (SELECT e.department_id
		 FROM employees e
                 JOIN departments d
                 ON (e.department_id = d.department_id)
                 JOIN locations l
                 ON (d.location_id = l.location_id)
                 JOIN countries c
                 ON (l.country_id = c.country_id)
                 WHERE country_name = p_landnaam)
    AND salary < p_nieuw_minimumloon;
    DBMS_OUTPUT.PUT_LINE('er werden ' || SQL%ROWCOUNT || ' rijen aangepast');
END;
/

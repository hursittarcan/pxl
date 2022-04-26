CREATE OR REPLACE TRIGGER bus_emp_sal
   BEFORE UPDATE OF salary
   ON employees
   FOR EACH ROW
   WHEN (OLD.hire_date < TO_CHAR(01-01-1995, 'dd-mm-yyyy'))
BEGIN
   IF (:NEW.salary > :OLD.salary * 1.05) THEN
      RAISE_APPLICATION_ERROR(-20000, 'salary teveel verhoogd!');
   ELSIF (:NEW.salary < :OLD.salary) THEN
      RAISE_APPLICATION_ERROR(-20001, 'Loonsverlaging kan niet!');
   END IF;
END;
/

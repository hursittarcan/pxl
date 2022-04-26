CREATE OR REPLACE PROCEDURE asterisk_sal
(p_emp_id employees.employee_id%type)
IS
     v_aantal_sterren   NUMBER(2);
     v_salary           employees.salary%type;
     v_outputstring     VARCHAR2(50);
BEGIN
     SELECT salary
     INTO v_salary
     FROM employees
     WHERE employee_id = p_emp_id;
     v_aantal_sterren := TRUNC(v_salary / 1000);
     v_outputstring := '';
     FOR i IN 1..v_aantal_sterren LOOP
          v_outputstring := CONCAT(v_outputstring, '*');
     END LOOP;
     DBMS_OUTPUT.PUT_line(v_outputstring);
END asterisk_sal;
/

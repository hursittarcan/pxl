CREATE OR REPLACE FUNCTION netto
(p_salary  employees.salary%type)
RETURN  VARCHAR2
AS
BEGIN
RETURN to_char(p_salary * 0.6, '999,999,999.00') || ' euro';
END;
/

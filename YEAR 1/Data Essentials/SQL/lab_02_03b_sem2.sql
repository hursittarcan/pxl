CREATE OR REPLACE FUNCTION netto2 
(p_bruto    employees.salary%type) 
RETURN VARCHAR2
AS
    v_netto    employees.salary%type; 
BEGIN
    IF p_bruto <= 10000 THEN 
        v_netto := p_bruto * 0.6; 
    ELSIF p_bruto <= 16000 THEN
        v_netto := 6000 + (p_bruto - 10000) * 0.5; 
    ELSE
        v_netto := 6000 + 3000 + (p_bruto - 16000) * 0.4; 
    END IF; 
    RETURN to_char(v_netto, '999,999,999,00') || ' euro'; 
END;
/

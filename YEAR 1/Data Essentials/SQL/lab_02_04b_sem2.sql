CREATE OR REPLACE FUNCTION schrikkeljaar
(p_jaar   number) 
RETURN varchar2 
AS
BEGIN
    IF mod(p_jaar, 400) = 0 OR (mod(p_jaar, 4) = 0 AND mod(p_jaar, 100) != 0) THEN
        return p_jaar || ' is een schrikkeljaar'; 
    ELSE 
        return p_jaar || ' is geen'; 
END IF;
END;
/

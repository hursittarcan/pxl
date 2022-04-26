CREATE OR REPLACE FUNCTION volgende_vergadering
RETURN date
AS
    v_datum date;
BEGIN
    v_datum := NEXT_DAY(LAST_DAY(sysdate), 'monday');
    IF TO_CHAR(v_datum, 'ddmm') = '0101' or TO_CHAR(v_datum, 'ddmm') = '0105' THEN
       v_datum := v_datum +1;
    END IF;
    return v_datum;
END;
/

CREATE OR REPLACE FUNCTION aantal_dienstjaren
(p_date  date)
RETURN number
AS
BEGIN
   RETURN TRUNC(months_between(sysdate, p_date) / 12);
END;
/

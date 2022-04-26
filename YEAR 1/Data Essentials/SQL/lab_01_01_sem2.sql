CREATE OR REPLACE FUNCTION dagen_einde_maand
RETURN NUMBER
AS
   v_aantal_dagen     NUMBER(3);
BEGIN
   v_aantal_dagen :=  to_number(LAST_DAY(sysdate) - sysdate);
   RETURN v_aantal_dagen;
END;
/

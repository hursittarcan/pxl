CREATE OR REPLACE TRIGGER auids_jobhis
   AFTER UPDATE OR INSERT OR DELETE
   ON job_history
DECLARE
   v_actie    varchar2(20);
BEGIN
   IF UPDATING THEN
      v_actie := 'update';
   ELSIF DELETING THEN
      v_actie := 'delete';
   ELSIF INSERTING THEN
      v_actie := 'insert';
   END IF;
   INSERT INTO log_history
   VALUES (USER, sysdate, v_actie);       
END;
/

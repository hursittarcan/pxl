CREATE OR REPLACE TRIGGER bus_jobs
	 BEFORE UPDATE
	 ON jobs
BEGIN
	 IF USER IN ('STUDENT', 'BEZOEKER') THEN
		 RAISE_APPLICATION_ERROR(-20000, 'Je hebt onvoldoende rechten om deze actie uit te voeren!');
	 ELSE
		 DBMS_OUTPUT.PUT_LINE('Ben je zeker? Anders doe meteen een rollback');
	 END IF;
END;
/

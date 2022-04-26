CREATE OR REPLACE TRIGGER bds_emp
BEFORE DELETE
ON employees
BEGIN
	IF USER != 'JAN' THEN
		RAISE_APPLICATION_ERROR(-20000,
		'u heeft geen rechten voor deze actie');
	END IF;
END;
/

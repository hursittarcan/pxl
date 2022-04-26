CREATE OR REPLACE PROCEDURE add_ctry
IS     v_country_id      countries.country_id%type := 'XP';
       v_country_name    countries.country_name%type := 'XP-land';
       v_region_id       countries.region_id%type := 1;
BEGIN
       INSERT INTO countries
       VALUES (v_country_id, v_country_name, v_region_id);
       DBMS_OUTPUT.PUT_LINE('Er werden ' || SQL%ROWCOUNT || ' rijen toegevoegd in de tabel COUNTRIES');
END add_ctry;
/

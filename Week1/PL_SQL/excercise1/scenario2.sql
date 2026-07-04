SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' promoted to VIP.');
    END LOOP;

    COMMIT;
END;
/
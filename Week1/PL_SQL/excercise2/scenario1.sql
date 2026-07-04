CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    -- Get sender balance
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_acc;

    -- Check sufficient balance
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
    END IF;

    -- Debit sender
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_acc;

    -- Credit receiver
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_acc;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
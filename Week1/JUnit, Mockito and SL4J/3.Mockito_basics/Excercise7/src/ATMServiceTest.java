import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ATMServiceTest {

    @Test
    public void testVoidException() {

        ATM mockATM = Mockito.mock(ATM.class);

        doThrow(new RuntimeException("Insufficient Cash"))
                .when(mockATM)
                .dispenseCash(5000);

        ATMService service = new ATMService(mockATM);

        assertThrows(RuntimeException.class, () -> {
            service.withdraw(5000);
        });
    }
}
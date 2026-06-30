import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    public void testArgumentMatching() {

        EmailService mockEmail = Mockito.mock(EmailService.class);

        NotificationService service = new NotificationService(mockEmail);

        service.notifyUser();

        verify(mockEmail).sendEmail(anyString(), anyString());
    }
}
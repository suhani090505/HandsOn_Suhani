import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Create service using mock object
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();

        // Verify that getData() was called
        verify(mockApi).getData();
    }
}
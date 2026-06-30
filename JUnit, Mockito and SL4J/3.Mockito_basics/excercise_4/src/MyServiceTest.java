import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethod() {

        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the void method
        doNothing().when(mockApi).saveData();

        // Create service
        MyService service = new MyService(mockApi);

        // Call method
        service.save();

        // Verify interaction
        verify(mockApi).saveData();
    }
}
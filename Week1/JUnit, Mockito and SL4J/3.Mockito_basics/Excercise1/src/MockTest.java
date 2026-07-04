import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MockTest {
    @Test
    public void testExternalApi(){
        ExternalApi mockapi=Mockito.mock(ExternalApi.class);
        when(mockapi.getData()).thenReturn("Mock Data");
        MyService service=new MyService(mockapi);
        String result=service.fetchData();
        assertEquals("Mock Data",result);
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherServiceTest {

    @Test
    public void testMultipleReturns() {

        WeatherApi mockApi = Mockito.mock(WeatherApi.class);

        when(mockApi.getTemperature())
                .thenReturn("25°C")
                .thenReturn("28°C")
                .thenReturn("30°C");

        WeatherService service = new WeatherService(mockApi);

        assertEquals("25°C", service.checkTemperature());
        assertEquals("28°C", service.checkTemperature());
        assertEquals("30°C", service.checkTemperature());
    }
}
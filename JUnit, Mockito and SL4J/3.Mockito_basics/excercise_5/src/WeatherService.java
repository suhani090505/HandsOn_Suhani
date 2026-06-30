public class WeatherService {

    private WeatherApi api;

    public WeatherService(WeatherApi api) {
        this.api = api;
    }

    public String checkTemperature() {
        return api.getTemperature();
    }
}
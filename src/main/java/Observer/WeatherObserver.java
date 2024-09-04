package Observer;

public class WeatherObserver {
    private String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    public void update(int temperature) {
        System.out.println(name + " received a temperature update: " + temperature + " degrees");
    }
}

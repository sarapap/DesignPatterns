package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.start();

        WeatherObserver observer1 = new WeatherObserver("Observer 1");
        WeatherObserver observer2 = new WeatherObserver("Observer 2");
        WeatherObserver observer3 = new WeatherObserver("Observer 3");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer2);
        System.out.println("Observer 2 removed.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.stop();
        System.out.println("Weather station simulation done.");
    }
}

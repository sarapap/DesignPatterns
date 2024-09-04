package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.start();

        WeatherObserver observer1 = new WeatherObserver("Observer 1");
        WeatherObserver observer2 = new WeatherObserver("Observer 2");
        WeatherObserver observer3 = new WeatherObserver("Observer 3");

        station.registerObserver(observer1);
        station.registerObserver(observer2);
        station.registerObserver(observer3);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        station.removeObserver(observer2);
        System.out.println("Observer 2 removed.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        station.stop();
        System.out.println("Weather station simulation done.");
    }
}

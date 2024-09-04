package Observer;

import java.util.List;
import java.util.ArrayList;

public class WeatherObserverList {
    private final List<WeatherObserver> observers;

    public WeatherObserverList() {
        observers = new ArrayList<>();
    }

    public synchronized void add(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void remove(WeatherObserver observer) {
        observers.remove(observer);
    }

    public synchronized void notifyObservers(int temperature) {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

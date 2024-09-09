package Observer;

public class WeatherStation {
    private int temperature;
    private boolean running;
    private Thread thread;
    private final WeatherObserverList observers;

    public WeatherStation() {
        temperature = (int) (Math.random() * 41) - 10; // -10 - 30 astetta
        running = false;
        observers = new WeatherObserverList();

        thread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep((int) (Math.random() * 4000 + 1000)); // 1-5 sekuntia
                } catch (InterruptedException e) {
                    return;
                }

                int change = (int) (Math.random() * 3) - 1;
                temperature += change;

                if (temperature < -10) {
                    temperature = -10;
                } else if (temperature > 30) {
                    temperature = 30;
                }

                notifyObservers();
            }
        });
    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread.start();
        }
    }

    public synchronized void stop() {
        running = false;
        thread.interrupt();
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        observers.notifyObservers(temperature);
    }
}

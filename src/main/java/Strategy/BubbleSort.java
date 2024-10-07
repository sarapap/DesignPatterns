package Strategy;

// Käytin apuna sivulla olevaa koodia, muokkasin vastaamaan omaa koodiani

public class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

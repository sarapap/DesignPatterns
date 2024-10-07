package Strategy;

// Käytin apuna sivulla olevaa koodia, muokkasin vastaamaan omaa koodiani

public class ShellSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i ++) {
                int temp = numbers[i];
                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
                    numbers[j] = numbers[j - gap];
                }
                numbers[j] = temp;
            }
        }
    }
}

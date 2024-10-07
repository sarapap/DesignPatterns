package Strategy;

// Käytin apuna sivulla olevaa koodia, muokkasin vastaamaan omaa koodiani

public class PancakeSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = n; i > 1; --i) {
            int maxIndex = findMaxIndex(numbers, i);
            if (maxIndex != i - 1) {
                flip(numbers, maxIndex);
                flip(numbers, i - 1);
            }
        }
    }

    private int findMaxIndex(int[] numbers, int n) {
        int maxIndex = 0;
        for (int i = 0; i < n;  ++i) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void flip(int[] numbers, int n) {
        int temp, start = 0;
        while (start < n) {
            temp = numbers[start];
            numbers[start] = numbers[n];
            numbers[n] = temp;
            start++;
            n--;
        }
    }
}

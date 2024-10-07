package Strategy;

public class Context {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] numbers) {
        sortingStrategy.sort(numbers);
    }
}

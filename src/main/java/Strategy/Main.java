package Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        int[] generate1 = Generator.generateNumbers(2000);
        int[] generate2 = Generator.generateNumbers(15000);

        context.setSortingStrategy(new BubbleSort());
        Generator.testPerformance(context, generate1, "Bubble Sort (small)");
        Generator.testPerformance(context, generate2, "Bubble Sort (large)");

        context.setSortingStrategy(new ShellSort());
        Generator.testPerformance(context, generate1, "Shell Sort (small)");
        Generator.testPerformance(context, generate2, "Shell Sort (large)");

        context.setSortingStrategy(new PancakeSort());
        Generator.testPerformance(context, generate1, "Pancake Sort (small)");
        Generator.testPerformance(context, generate2, "Pancake Sort (large)");
    }
}

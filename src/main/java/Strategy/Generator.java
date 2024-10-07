package Strategy;

public class Generator {
    public static int[] generateNumbers(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * 100000);
        }
        return numbers;
    }

    protected static void testPerformance(Context context, int[] dataSet, String algorithmName) {
        int[] dataCopy = dataSet.clone();
        long startTime = System.nanoTime();
        context.sort(dataCopy);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println(algorithmName + " took " + duration + " ms");
    }
}

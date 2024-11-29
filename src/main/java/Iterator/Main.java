package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();

        Iterator<Integer> iterator = sequence.iterator();
        int count = 10;
        while (iterator.hasNext() && count-- > 0) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

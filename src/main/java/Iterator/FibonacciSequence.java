package Iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    // Päätin sijoittaa Fibonacci-lukujonon laskennan tilan FibonacciIterator-luokkaan,
    // koska iteraattorin pitäisi olla itsenäinen eikä aiheuta ristiriitoja muiden kanssa.
    // Muuten kaikki iteraattorit jakaisivat saman tilan. Tämä voisi johtaa siihen, että yksi
    // iteraattori, joka muuttaa Fibonacci-jonoa, saattaisi vaikuttaa toisiin iteraattoreihin.
}

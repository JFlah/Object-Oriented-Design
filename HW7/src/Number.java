import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jack on 11/5/2016.
 */
public class Number implements Polynomial {
    private int number;

    public Number(int number) {
        this.number = number;
    }
    @Override
    public int evaluate(Map<String, Integer> m) {
        return number;
    }

    @Override
    public Polynomial reduce() {
        return this;
    }

    @Override
    public boolean equals(Polynomial p) {
        if (!(p instanceof Number)) {
            return false;
        }
        return this.toString().equals(p.toString());
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public Iterator<Polynomial> iterator() {
        return new Iterator<Polynomial>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Polynomial next() {
                return null;
            }
        };
    }
}

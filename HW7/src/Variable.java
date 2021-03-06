import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jack on 11/5/2016.
 */
public class Variable implements Polynomial {
    private String variable;

    public Variable(String variable) {
        this.variable = variable;
    }
    @Override
    public int evaluate(Map<String, Integer> m) {
        return m.get(variable);
    }

    @Override
    public Polynomial reduce() {
        return this;
    }

    @Override
    public boolean equals(Polynomial p) {
        if (!(p instanceof Variable)) {
            return false;
        }
        return this.toString().equals(p.toString());
    }

    @Override
    public String toString() {
        return variable;
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

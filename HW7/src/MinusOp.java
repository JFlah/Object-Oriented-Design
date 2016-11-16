import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jack on 11/5/2016.
 */
public class MinusOp implements Polynomial {
    private Polynomial p1;
    private Polynomial p2;

    public MinusOp(Polynomial p1, Polynomial p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    @Override
    public int evaluate(Map<String, Integer> m) {
        return p1.evaluate(m) - p2.evaluate(m);
    }

    @Override
    public Polynomial reduce() {
        Polynomial reducedP1 = p1.reduce();
        Polynomial reducedP2 = p2.reduce();

        if (reducedP1.equals(reducedP2)) {
            return new Number(0);
        }

        if (reducedP1 instanceof Number) {
            if (reducedP2 instanceof Number) {
                return new Number(reducedP1.evaluate(null) - reducedP2.evaluate(null));
            }
            if (reducedP1.evaluate(null) == 0) {
                return reducedP2.reduce();
            }
        }

        if (reducedP2 instanceof Number) {
            if (reducedP1.evaluate(null) == 1) {
                return reducedP1.reduce();
            }
        }

        return new MinusOp(reducedP1, reducedP2);
    }

    @Override
    public boolean equals(Polynomial p) {
        if (!(p instanceof MinusOp)) {
            return false;
        }
        boolean p1Found = false, p2Found = false;
        Iterator<Polynomial> iter = p.iterator();
        while (iter.hasNext()) {
            Polynomial currPolyOther = iter.next();
            if (!p1Found) {
                p1Found = p1.equals(currPolyOther);
            }
            if (!p2Found) {
                p2Found = p2.equals(currPolyOther);
            }
        }
        return p1Found && p2Found;
    }

    @Override
    public String toString() {
        return "(" + p1.toString() + " - " + p2.toString() + ")";
    }

    @Override
    public Iterator<Polynomial> iterator() {
        return new Iterator<Polynomial>() {
            int i = 1;
            @Override
            public boolean hasNext() {
                return i <= 2;
            }

            @Override
            public Polynomial next() {
                if (i == 1) {
                    i++;
                    return p1;
                } else {
                    i++;
                    return p2;
                }
            }
        };
    }
}

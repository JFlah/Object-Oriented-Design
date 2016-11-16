import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Jack on 11/5/2016.
 */
public interface Polynomial extends Iterable<Polynomial> {
    String toString();
    boolean equals(Polynomial p);
    int evaluate(Map<String, Integer> m);
    Polynomial reduce();
    default void traverse(Consumer<Polynomial> c) {
        c.accept(this);
        forEach(p->p.traverse(c));
    }
}

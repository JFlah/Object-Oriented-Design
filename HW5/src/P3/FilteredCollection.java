package P3;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Jack on 10/18/2016.
 */
public class FilteredCollection<T> extends AbstractCollection<T> {
    private Collection<T> collection = new HashSet<T>();

    public FilteredCollection(Predicate<T> pred, Collection<T> coll) {
        for (T s : coll) {
            if (pred.test(s)) {
                collection.add(s);
            }
        }
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}

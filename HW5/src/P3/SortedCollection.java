package P3;

import java.util.*;

/**
 * Created by Jack on 10/18/2016.
 */
public class SortedCollection<T> extends AbstractCollection<T> {
    private List<T> collection = new ArrayList<T>();

    public SortedCollection(Comparator<T> comp, Collection<T> coll) {
        for (T s : coll) {
            collection.add(s);
        }
        Collections.sort(collection, comp);
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

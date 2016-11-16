package P3;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Jack on 10/18/2016.
 */
public class MergedCollection<String> extends AbstractCollection<String> {
    private Collection<String> c1;
    private Collection<String> c2;

    public MergedCollection(Collection<String> c1, Collection<String> c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int size() {
        return c1.size()+c2.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new MergedIterator(c1, c2);
    }
}

class MergedIterator<String> implements Iterator<String> {
    Iterator<String> itC1;
    Iterator<String> itC2;
    public MergedIterator(Collection<String> c1, Collection<String> c2) {
        itC1 = c1.iterator();
        itC2 = c2.iterator();
    }

    @Override
    public boolean hasNext() {
        return (itC1.hasNext() || itC2.hasNext());
    }

    @Override
    public String next() {
        if (itC1.hasNext()) {
            return itC1.next();
        }
        return itC2.next();
    }
}

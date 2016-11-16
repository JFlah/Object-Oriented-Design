package P3;

import java.util.function.Predicate;

/**
 * Created by Jack on 10/18/2016.
 */
public class StringPrefix implements Predicate<String> {
    String prefix;
    public StringPrefix(String prefix) {
        this.prefix = prefix;
    }
    public boolean test(String s) {
        return s.startsWith(prefix);
    }
}

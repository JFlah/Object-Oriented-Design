package P3;

import java.util.function.Predicate;

/**
 * Created by Jack on 10/18/2016.
 */
public class StringLength implements Predicate<String> {
    int len;
    public StringLength(int len) {
        this.len = len;
    }
    public boolean test(String s) {
        return s.length() <= len;
    }
}

import java.util.Collection;

/**
 * Created by Jack on 12/5/2016.
 */
public interface FTModelObserver {
    void isSuspended(boolean b);
    void update(Collection<Fish> fishes);
}

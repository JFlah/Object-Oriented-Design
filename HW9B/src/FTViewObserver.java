import java.awt.*;

/**
 * Created by Jack on 12/5/2016.
 */
public interface FTViewObserver {
    void newFish(String fishType);
    void startStopPressed();
    void setSize(Dimension d);
}

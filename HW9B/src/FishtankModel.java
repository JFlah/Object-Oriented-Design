import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jack on 12/5/2016.
 */
public class FishtankModel implements ActionListener {
    private FTModelObserver observer;
    private boolean suspended = false;
    private Collection<Fish> fishes = new ArrayList<>();
    private Dimension tankSize;
    private FishPanel panel;
    private CountPanel cPanel;

    public void newFish(String fishType, FishtankView view) {
        FishFactory ff = FishFactory.getFactory(fishType);
        Fish f = ff.create(view);
        fishes.add(f);
        cPanel.incrementFishLabel();
    }

    public void startStopPressed() {
        suspended = !suspended;
    }

    public void setSize(Dimension d) {
        this.tankSize = d;
    }

    public Dimension getTankSize() {
        return tankSize;
    }

    public void addPanel(FishPanel panel) {
        this.panel = panel;
    }

    public void addCPanel(CountPanel cPanel) {
        this.cPanel = cPanel;
    }

    public void addObserver(FTModelObserver observer) {
        this.observer = observer;
    }

    public void tick() {
        if (!suspended) {
            for(Fish f : fishes)
                f.move(panel.panelSize());
            observer.update(fishes);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tick();
    }
}

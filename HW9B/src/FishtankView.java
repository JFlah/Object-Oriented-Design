import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Collection;

/**
 * Created by Jack on 12/5/2016.
 */
public class FishtankView {
    private FTViewObserver observer;
    private FishPanel panel;

    private ImageIcon meanFishLeft = new ImageIcon("./images/Lmeaniefish.gif");
    private ImageIcon meanFishRight = new ImageIcon("./images/Rmeaniefish.gif");

    private ImageIcon angelFishLeft = new ImageIcon("./images/Langelfish.gif");
    private ImageIcon angelFishRight = new ImageIcon("./images/Rangelfish.gif");

    private ImageIcon octopusLeft = new ImageIcon("./images/Loctopus.gif");
    private ImageIcon octopusRight = new ImageIcon("./images/Roctopus.gif");

    public FishtankView() {

    }

    public void addPanel(FishPanel panel) {
        this.panel = panel;
        this.panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                System.out.println(e.getSource().toString());
            }
        });
    }

    public FishPanel getPanel() {
        return panel;
    }

    public void isSuspended(boolean b) {

    }

    public void update(Collection<Fish> fishes) {
        panel.doRepaint(fishes);
    }

    public void addObserver(FTViewObserver observer) {
        this.observer = observer;
    }

    public ImageIcon getMeanFishLeft() {
        return meanFishLeft;
    }

    public ImageIcon getMeanFishRight() {
        return meanFishRight;
    }

    public ImageIcon getAngelFishLeft() {
        return angelFishLeft;
    }

    public ImageIcon getAngelFishRight() {
        return angelFishRight;
    }

    public ImageIcon getOctopusLeft() {
        return octopusLeft;
    }

    public ImageIcon getOctopusRight() {
        return octopusRight;
    }
}

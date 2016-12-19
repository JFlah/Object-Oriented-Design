import javax.swing.*;

/**
 * Created by Jack on 12/6/2016.
 */
public class CountFrame extends JFrame {
    private FishtankModel model;
    private CountPanel panel;
    public CountFrame(FishtankModel model) {
        setTitle("Fish Counter");
        setSize(250, 75);
        setLocation(20, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new CountPanel();
        getContentPane().add(panel);
        model.addCPanel(panel);
        Timer visTimer = new Timer(100, panel);
        visTimer.start();
    }
}

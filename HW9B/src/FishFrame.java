import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class FishFrame extends JFrame {
   private FishPanel panel;
   
   public FishFrame(FishtankController controller) {
      setTitle("Fish Tank");
      Dimension tankSize = controller.getModel().getTankSize();
      setSize(tankSize.width, tankSize.height);
      setLocation(20,20);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      panel = new FishPanel();
      controller.getView().addPanel(panel);
      controller.getModel().addPanel(panel);
      setJMenuBar(new FishMenuBar(panel, controller));
      getContentPane().add(panel);
   }
}
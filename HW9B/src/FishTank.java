import javax.swing.*;
import java.awt.*;

public class FishTank {
   public static void main(String[] args) {
      FishtankView view = new FishtankView();
      Dimension tankSize = new Dimension(650, 400);
      FishtankModel model = new FishtankModel();
      model.setSize(tankSize);
      FishtankController controller = new FishtankController(view, model);
      FishFrame frame = new FishFrame(controller);
      frame.setVisible(true);

      CountFrame cFrame = new CountFrame(model);
      cFrame.setVisible(true);

      Timer t = new Timer(100, model);
      t.start();  //do the animation forever
   }
}

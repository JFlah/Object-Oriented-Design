import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FishFrame extends JFrame implements ActionListener {
   private FishPanel panel;
   public static final int TANK_WIDTH = 650;
   public static final int TANK_HEIGHT = 400;

   public FishFrame() {
      setTitle("Fish Tank");
      setSize(TANK_WIDTH, TANK_HEIGHT);
      setLocation(20,20);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      panel = new FishPanel();
      setJMenuBar(new FishMenuBar(panel));
      getContentPane().add(panel);
   }
   
   public void actionPerformed(ActionEvent e) { // called by the timer
      panel.tick();
   }
}
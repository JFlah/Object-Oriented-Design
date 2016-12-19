import javax.swing.*;

@SuppressWarnings("serial")
public class FishMenuBar extends JMenuBar {
   
   public FishMenuBar(FishPanel fp, FishtankController controller) {  // set up the menu bar
      JMenu animation = new JMenu("Animation");
      add(animation);
   		JMenuItem startstop = new JMenuItem("Stop");
      animation.add(startstop);
      startstop.addActionListener(e->{
      		controller.startStopPressed();
      		String label = startstop.getText();
      		String newlabel = label.equals("Start") ? "Stop" : "Start";
      		startstop.setText(newlabel);
      });
      
      JMenu newmenu = new JMenu("New Fish");
      add(newmenu);
      JMenuItem angelfish = new JMenuItem("Angel Fish");
      newmenu.add(angelfish);
      angelfish.addActionListener(e->controller.newFish(angelfish.getText()));
      JMenuItem meanie = new JMenuItem("Mean Fish");
      newmenu.add(meanie);
      meanie.addActionListener(e->controller.newFish(meanie.getText()));
      JMenuItem octopus = new JMenuItem("Octopus");
      newmenu.add(octopus);
      octopus.addActionListener(e->controller.newFish(octopus.getText()));
   }
}

